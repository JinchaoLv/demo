package com.lvjc.sevice;

import com.lvjc.annotation.EnableLogger;
import com.lvjc.bean.Host;
import com.lvjc.utils.FileUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

/**
 * Created by lvjc on 2017/11/2.
 */
@EnableLogger("com.lvjc.service.HostsService")
@Service
public class HostsService implements InitializingBean {

    private static final String USER_HOSTS_PATH = "F:\\demo\\hosts-switcher\\src\\main\\resources\\hosts\\";
    private static final String SYSTEM_HOSTS_FILE = "C:/Windows/System32/drivers/etc/hosts";
    private static final String EMPTY_SCHEME = "";
    private static final String SCHEME_INFO_HEAD = "#scheme:";

    private String currentScheme = null;
    private boolean needUpdate = true;

    //@EnableLogger
    public String getHosts(String scheme){
        String hostFileName = scheme == null ? SYSTEM_HOSTS_FILE : USER_HOSTS_PATH + scheme;
        return FileUtil.readFile(hostFileName);
    }

    public void newScheme(String scheme) throws IOException {
        String schemeLine = this.schemeLine(scheme) + "\r\n";
        String fileName = USER_HOSTS_PATH + scheme;
        FileUtil.writeFile(schemeLine, fileName, false);
    }

    public List<String> getSchemes(){
        return FileUtil.getDictionaryFileNames(USER_HOSTS_PATH);
    }

    public void addHosts(List<Host> hosts) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        for(Host host : hosts){
            stringBuilder.append("\r\n");
            stringBuilder.append(host.getIp() + " " + host.getHostName());
        }
        FileUtil.writeFile(stringBuilder.toString(), SYSTEM_HOSTS_FILE, true);
        needUpdate = true;
    }

    public void addHosts(String hosts) throws IOException {
        FileUtil.writeFile("\r\n" + hosts, SYSTEM_HOSTS_FILE, true);
        needUpdate = true;
    }

    public void switchHosts(String scheme) throws IOException {
        if(scheme != null && !scheme.equals(currentScheme)){
            if(needUpdate){
                this.updateScheme();
                needUpdate = false;
            }
            FileUtil.copyFile(USER_HOSTS_PATH + scheme, SYSTEM_HOSTS_FILE);
            this.refreshCurrentScheme();
        }
    }

    private void refreshCurrentScheme(){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(SYSTEM_HOSTS_FILE)))){
            String schemeLine = reader.readLine();
            currentScheme = this.decryptScheme(schemeLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String decryptScheme(String schemeLine){
        if(schemeLine.startsWith(SCHEME_INFO_HEAD))
            return schemeLine.substring(SCHEME_INFO_HEAD.length());
        else
            return EMPTY_SCHEME;
    }

    private String schemeLine(String scheme){
        return SCHEME_INFO_HEAD + scheme;
    }

    private void updateScheme() throws IOException {
        FileUtil.copyFile(SYSTEM_HOSTS_FILE, USER_HOSTS_PATH + currentScheme);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        this.refreshCurrentScheme();
    }
}
