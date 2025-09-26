package top.villion.www;

import java.util.ArrayList;

public class PackageIO {
    public static void savePackagesToFile(ArrayList<PackageInfo> packages, String filename) {
        // 这里实现将packages集合保存到指定文件的逻辑
        try {
            java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.FileWriter(filename));
            for (PackageInfo p : packages) {
                writer.println(p.toCSV());
            }
            writer.close();
        } catch (java.io.IOException e) {
            System.out.println("保存文件时出错: " + e.getMessage());
        }
    }

    public static ArrayList<PackageInfo> loadPackagesFromFile(String filename) {
        ArrayList<PackageInfo> packages = new ArrayList<>();
        try {
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    packages.add(PackageInfo.fromCSV(line));
                } catch (IllegalArgumentException e) {
                    System.out.println("跳过无效的CSV行: " + line);
                }
            }
            reader.close();
        } catch (java.io.IOException e) {
            System.out.println("读取文件时出错: " + e.getMessage());
        }
        return packages;
    }
}
