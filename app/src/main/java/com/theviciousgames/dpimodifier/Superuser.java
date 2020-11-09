package com.theviciousgames.dpimodifier;

import java.util.ArrayList;
import java.util.List;

import eu.chainfire.libsuperuser.Shell;

public class Superuser {
    public static String executeCommandSU(String command) {
        List<String> stdout = new ArrayList<>();
        List<String> stderr = new ArrayList<>();
        try {
            Shell.Pool.SU.run(command, stdout, stderr, true);
        } catch (Shell.ShellDiedException e) {
            e.printStackTrace();
        }
        if (stdout == null)
            return null;
        StringBuilder stringBuilder = new StringBuilder();
        for (String line : stdout) {
            stringBuilder.append(line).append("\n");
        }
        return stringBuilder.toString();
    }
}
