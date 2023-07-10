package VitoBarra.JavaUtil.Other;

import java.awt.*;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.security.ProtectionDomain;

public class ConsoleStarter {
    public static Boolean ConsoleStarter(ProtectionDomain domain) throws IOException {

        Console console = System.console();
        if (console == null && !GraphicsEnvironment.isHeadless()) {
            String filePath = domain.getCodeSource().getLocation().toString().substring(6).replace("%20", " ");
            filePath = new File(filePath).getAbsolutePath();
            Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start", "cmd", "/k", "java", "-jar", filePath});
            return false;
        } else {
            System.setProperty("console.encoding", "UTF-8");
            return true;
        }
    }
}
