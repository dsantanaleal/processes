package com.dsantanaleal.windowstools.processes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {



    public static void main(String[] args) throws IOException {
        /*ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "tasklist /svc /FI \"PDI eq \"");*/
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "netstat");
        builder.redirectErrorStream(true);
        Process process = builder.start();

        try(InputStreamReader is = new InputStreamReader(process.getInputStream());
            BufferedReader br = new BufferedReader(is)) {
            //List<String[]> result =
                    br.lines().filter(line -> !line.trim().isEmpty() && !line.trim().equals("Active Connections"))
                    .map(line->line.trim().replaceAll(" +", "|"))
                    .map(line->line.split("\\|"))
                    .forEach(line -> System.out.println(Arrays.toString(line)));
                    //.collect(Collectors.toList());
            //String line = result.get(0).trim().replaceAll(" +", " ");
            //System.out.println(result.get(0).trim().replaceAll(" +", " "));
            //System.out.println();
            //System.out.println(Arrays.toString(result.get(0).split("\t")));
            //result.forEach(System.out::println);
        }
    }
}
