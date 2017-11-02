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

    private static final String PATH = "C:/Windows/System32/drivers/etc/";
    private static final String CURRENT_HOSTS = "hosts";
    private static final String EMPTY_SCHEME = "";
    private static final String SCHEME_INFO_HEAD = "#scheme:";

    private String currentScheme = null;
    private boolean needUpdate = false;


    public String getHosts(String scheme){
        scheme = scheme == null ? CURRENT_HOSTS : scheme;
        String hostFileName = PATH + scheme;
        return FileUtil.readFile(hostFileName);
    }

    public void addHosts(List<Host> hosts) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        for(Host host : hosts){
            stringBuilder.append(host.getIp() + " " + host.getHostName());
            stringBuilder.append("\r\n");
        }
        String hostFileName = PATH + CURRENT_HOSTS;
        FileUtil.writeFile(stringBuilder.toString(), hostFileName, true);
        needUpdate = true;
    }

    public void switchHosts(String scheme) throws IOException {
        if(scheme != null && !scheme.equals(currentScheme)){
            if(needUpdate){
                this.updateScheme();
            }
            FileUtil.copyFile(PATH + scheme, PATH + CURRENT_HOSTS);
        }
    }

    private String getCurrentScheme(){
        if(currentScheme == null){
            String hostFileName = PATH + CURRENT_HOSTS;
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
        FileUtil.copyFile(PATH + CURRENT_HOSTS, PATH + currentScheme);
    }


}
