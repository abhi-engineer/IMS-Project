/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import database.InventoryUtils;
import java.awt.Desktop;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author abhi
 */
public class OpenPdf {

    public static void openById(String id) {
        try {
            String filePath = InventoryUtils.billPath + id + ".pdf"; // Replace `id` with your variable

            File file = new File(filePath);
            if (file.exists()) {
                try {
                    Process p = Runtime.getRuntime().exec("firefox " + file.getAbsolutePath());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error opening file: " + e.getMessage());
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
