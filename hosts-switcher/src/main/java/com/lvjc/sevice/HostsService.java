package com.lvjc.sevice;

import com.lvjc.bean.Host;
import com.lvjc.utils.FileUtil;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

/**
 * Created by lvjc on 2017/11/2.
 */
@Service
public class HostsService {

    private static final String USER_HOSTS_PATH = "F:\\demo\\hosts-switcher\\src\\main\\resources\\hosts\\";
    private static final String SYSTEM_HOSTS_File = "C:/Windows/System32/drivers/etc/hosts";
    private static final String EMPTY_SCHEME = "";
    private static final String SCHEME_INFO_HEAD = "#scheme:";

    private String currentScheme = null;
    private boolean needUpdate = false;


    public String getHosts(String scheme){
        String hostFileName = scheme == null ? SYSTEM_HOSTS_File : USER_HOSTS_PATH + scheme;
        return FileUtil.readFile(hostFileName);
    }

    public void addHosts(List<Host> hosts) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        for(Host host : hosts){
            stringBuilder.append("\r\n");
            stringBuilder.append(host.getIp() + " " + host.getHostName());
        }
        FileUtil.writeFile(stringBuilder.toString(), SYSTEM_HOSTS_File, true);
        needUpdate = true;
    }

    public void switchHosts(String scheme) throws IOException {
        if(scheme != null && !scheme.equals(currentScheme)){
            if(needUpdate){
                this.updateScheme();
            }
            FileUtil.copyFile(USER_HOSTS_PATH + scheme, SYSTEM_HOSTS_File);
        }
    }

    private String getCurrentScheme(){
        if(currentScheme == null){
            String hostFileName = SYSTEM_HOSTS_File;
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(hostFileName)))){
                String schemeLine = reader.readLine();
                currentScheme = decryptScheme(schemeLine);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return currentScheme;
    }

    private String decryptScheme(String schemeLine){
        if(schemeLine.startsWith(SCHEME_INFO_HEAD))
            return schemeLine.substring(SCHEME_INFO_HEAD.length());
        else
            return EMPTY_SCHEME;
    }

    private void updateScheme() throws IOException {
        FileUtil.copyFile(SYSTEM_HOSTS_File, USER_HOSTS_PATH + currentScheme);
    }


}
