package IO;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class FileUtil {
    public static void decompressGzipFile(String gzipFile, String newFile) {
        try (GZIPInputStream gis = new GZIPInputStream(new FileInputStream(gzipFile)); FileOutputStream fos = new FileOutputStream(newFile)) {
            byte[] buffer = new byte[1024];

            for (int len = gis.read(buffer); len != -1; len = gis.read(buffer))
                fos.write(buffer, 0, len);


        } catch (IOException e) {
            System.out.println("errore:" + gzipFile);
            //e.printStackTrace();
        }

    }

    public static void compressGzipFile(String Filepath, String gzipFilePath) {
        if (!PathUtil.CreateDir(PathUtil.GetParentDirOfFile(gzipFilePath, 1))) return;

        try (FileInputStream fis = new FileInputStream(Filepath); GZIPOutputStream gzipOS = new GZIPOutputStream(new FileOutputStream(gzipFilePath))) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1)
                gzipOS.write(buffer, 0, len);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static boolean CreateFileIfNotExists(String FilePath) {
        var yourFile = new File(FilePath);
        try {
            return yourFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static List<String> ReadAllLine(String NameFile) throws IOException {
        var LineList = new LinkedList<String>();
        var Reader = new BufferedReader(new FileReader(NameFile));

        for (String line = Reader.readLine(); line != null; line = Reader.readLine())
            LineList.add(line);

        return LineList;
    }

    public static void WriteAllLine(List<String> StrList, String Path, Boolean ReWrite) {
        try (var Writer = new BufferedWriter(new FileWriter(Path))) {
            if (ReWrite) {
                Writer.write(StrList.get(0));
                StrList.remove(0);
            }

            for (var l : StrList)
                Writer.append(l).append("\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void WriteFile(String Path, String str) {
        if (Path == null) return;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Path))) {
            writer.write(str);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
