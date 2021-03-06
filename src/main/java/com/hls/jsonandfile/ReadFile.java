package com.hls.jsonandfile;

import java.io.*;

/**
 * @Package: com.hls.jsonandfile
 * @Author: helishi
 * @CreateDate: 2017/12/11
 * @Description: 读取文件的几种方式 和 追加内容在文件内容尾部
 */
public class ReadFile {
    /**
     * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。
     */
    public static void readFileByBytes(String filePath){
        File file = new File(filePath);
        InputStream in = null;
        //一次读一个字节
        try{
            System.out.print("以字节为单位读取文件内容，一次读一个字节：");
            in = new FileInputStream(file);
            int tempbyte;
            while ((tempbyte = in.read()) != -1){
                System.out.print(tempbyte);
            }
            in.close(); //记得关闭流
        }catch (IOException e){
            e.printStackTrace();
            return;
        }
        //一次读多个字节
        try{
            System.out.print("以字节为单位读取文件内容，一次读多个字节：");
            byte[] tempbyte = new byte[100];
            int byteread = 0;
            in = new FileInputStream(filePath);
            ReadFile.showAvailableBytes(in);
            while ((byteread = in.read(tempbyte)) != -1){
                System.out.write(tempbyte,0,byteread);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (in != null){
                try {
                    in.close(); //记得关闭流
                }catch (IOException e){
                }
            }
        }
    }
    /**
     * 显示流中还剩的字节数
     */
    
    private static void showAvailableBytes(InputStream in){
            try {
                System.out.print("当前字节输入流中的字节数为："+in.available());
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    /**
     * 以字符为单位读取文件，常用于读文本，数字等类型的文件
     */
    public static void readFileByChars(String filePath){
        File file = new File(filePath);
        Reader reader = null;
        try{
            System.out.print("以字符为单位读取文件内容，一次读取一个字符：");
            reader = new InputStreamReader(new FileInputStream(file),"gbk");
            int tempchar;
            while((tempchar = reader.read()) != -1){
                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                // 但如果这两个字符分开显示时，会换两次行。
                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
                if (((char)tempchar) != '\r'){
                    System.out.print((char)tempchar);
                }
            }
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            System.out.print("以字符为单位读取文件内容，一次读多个字符：");
            char[] tempchars = new char[30];
            int charread = 0;
            reader = new InputStreamReader(new FileInputStream(filePath),"gbk");
            //读入多个字符到字符数组中，charread为一次读取字符数
            while ((charread = reader.read(tempchars)) != -1){
                //同样屏蔽掉\r不显示
                if ((charread == tempchars.length) && (tempchars[tempchars.length - 1] != '\r')){
                    System.out.print(tempchars);
                }else{
                    for (int i = 0; i < charread; i++){
                        if (tempchars[i] == '\r'){
                            continue;
                        }else {
                            System.out.print(tempchars[i]);
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (reader != null){
             try{
                 reader.close();
             }catch (IOException e){
             }
            }
        }
    }
    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static void readFileByLines(String filePath){
        File file = new File(filePath);
        BufferedReader reader = null;
        try {
            System.out.print("以行为单位读取文件内容，一次读一整行:");
            //reader = new BufferedReader(new FileReader(file));
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"gbk")); // 解决.txt文件中文乱码
            String tempString = null;
            int line = 1;
            while ((tempString = reader.readLine()) != null){
                //显示行号
                System.out.print("line"+line+" : "+tempString);
                line++;
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 随机读取文件内容
     */
    public static void readFileByRandomAccess(String filePath){
        RandomAccessFile randomAccessFile = null;
        System.out.print("随机读取一段文件内容：");
        //打开一个随机访问文件流，按只读方式
        try {
            randomAccessFile = new RandomAccessFile(filePath,"r");
            //文件长度，字节数
            long fileLength = randomAccessFile.length();
            //读文件的起始位置
            int beginIndex = (fileLength > 4 ) ? 4 : 0;
            // 将文件的开始位置到beginIndex位置
            randomAccessFile.seek(beginIndex);
            byte[] bytes = new byte[10];
            int byteread = 0;
            //处理乱码的方式
            /*String s = randomAccessFile.readLine();
            s = new String(s.getBytes("8859_1"),"gbk");*/
            //一次读10个字节，如果文件内容不足10个字节，则读剩下的字节
            //将一次读取的字节数赋给byteread
            while ((byteread = randomAccessFile.read(bytes)) != -1){
                System.out.write(bytes,0,byteread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (randomAccessFile != null){
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * A方法追加文件：使用RandomAccessFile
     */
    public static void appendMethodA(String filePath, String content) {
        try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(filePath, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            //将写文件指针移到文件尾。
            randomFile.seek(fileLength);
            randomFile.writeBytes(content);
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * B方法追加文件：使用FileWriter
     */
    public static void appendMethodB(String filePath, String content) {
        try {
            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
