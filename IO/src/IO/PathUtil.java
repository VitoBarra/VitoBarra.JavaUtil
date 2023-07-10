package IO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class PathUtil
{

    public static List<File> FilesFromPath(String PathOfFolder)
    {
        var WrapperList = new ArrayList<String>(1);
        WrapperList.add(PathOfFolder);
        return CreateFileList(WrapperList);
    }
    public static List<File> FilesFromPaths(String line, String splitRegex)
    {
        var paths = Arrays.stream(line.split(splitRegex)).toList();
        return CreateFileList(paths);
    }

    public static List<File> FilesFromPaths(List<String> paths)
    {
        return CreateFileList(paths);
    }

    private static List<File> CreateFileList(List<String> paths)
    {
        Set<File> FilePathSet = new HashSet<>();
        for (var path : paths)
        {
            var File = new File(path);

            if (File.isDirectory())
                ListFilePathsFormFolder(File, FilePathSet);
            else
                FilePathSet.add(File);
        }

        return FilePathSet.stream().filter(File::isFile).toList();
    }

    private static void ListFilePathsFormFolder(File folder, Set<File> set)
    {
        var FileInFolder = folder.listFiles();
        if (FileInFolder == null) return;

        for (final File fileEntry : FileInFolder)
        {
            if (!set.add(fileEntry)) continue;

            if (fileEntry.isDirectory())
                ListFilePathsFormFolder(fileEntry, set);
        }
    }


    public static String GetParentDirOfFile(String FileNamePath, int Uplevel)
    {
        var pathPart = GetFilePathPart(FileNamePath);
        if (Uplevel < 1 || Uplevel > pathPart.length) throw new IllegalArgumentException();


        return Arrays.stream(Arrays.copyOf(pathPart, pathPart.length - Uplevel))
                     .reduce((s, s2) -> s + "\\" + s2).orElse(null);

    }

    public static String GetPathToFileWithoutExtension(String FileNamePath)
    {
        var pathPart = GetFilePathPart(FileNamePath);
        String FileName = GetFileNameWithoutExtension(pathPart);

        return Arrays.stream(Arrays.copyOf(pathPart, pathPart.length - 1))
                     .reduce((s, s2) -> s + "\\" + s2)
                     .map(s -> s + FileName)
                     .orElse(null);
    }

    public static String GetOnlyFileName(String path)
    {
        var PathPart =GetFilePathPart(path);
        return PathPart[PathPart.length - 1];
    }
    public static String GetFileNameWithoutExtension(String path)
    {
        return GetFileNameWithoutExtension(GetFilePathPart(path));
    }

    private static String GetFileNameWithoutExtension(String[] pathPart)
    {
        return pathPart[pathPart.length - 1].split("\\.")[0];
    }

    private static String[] GetFilePathPart(String FileNamePath)
    {
        return FileNamePath.split("\\\\");
    }



    public static boolean CreateDir(String path)
    {
        var directory = new File(path);
        return directory.exists() || directory.mkdirs();
    }
    public static boolean DeleteDir(String path) throws IOException
    {

        Path pathToBeDeleted = new File(path).toPath();
        if(!Files.exists(pathToBeDeleted)) return true;

        Files.walk(pathToBeDeleted)
             .sorted(Comparator.reverseOrder())
             .map(Path::toFile)
             .forEach(File::delete);

        return Files.exists(pathToBeDeleted);
    }


}
