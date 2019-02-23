/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project34;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.lang.Exception;
import java.net.*;
import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;
import javazoom.jl.player.Player;
/**
 *
 * @author Black2
 */
public class Project34 extends javax.swing.JFrame {
    
    private Player myplayer;
    private File fileCurrentlyPlaying;
    private ArrayList <File> filePlaylist = new ArrayList();
    private final File playlistPhysicalFile = new File("playlist.txt");
    private static Thread a;
    private static int iterator;
    private static boolean RepeatMode;
    private boolean Browsed;

    private Thread b;
    public Project34() {
        initComponents();
        this.ReadPlaylistFile();
        this.DrawPlaylist();
        this.setSize(377, 288);
        this.Browsed = false;
        if(fileCurrentlyPlaying==null)
        {
            this.jTextFieldPlayingFile.setText("No file selected!");
        }
        jListPlaylist.setFocusable(false);
        jListPlaylist.setOpaque(false);
        jListPlaylist.setVerifyInputWhenFocusTarget(false);
        jScrollPane2.setViewportView(jListPlaylist);
        jListPlaylist.getAccessibleContext().setAccessibleName("");
        this.jButtonPlay.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent actionEvent) 
            {
                String value = jListPlaylist.getSelectedValue();
                if(filePlaylist!=null && !filePlaylist.isEmpty() && !Browsed)
                {
                   for(File s : filePlaylist)
                    {
                        if(value!=null)
                        {
                           if(s.getName().compareTo(value)==0)
                           {    
                                fileCurrentlyPlaying = s;
                                if(fileCurrentlyPlaying!=null)
                                {
                                   PlaySongFile();
                                   break;
                                }
                           }
                        }
                   }
                }
           }
        });
        iterator = 0;
        javax.swing.Timer timer = new javax.swing.Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(a!=null&&RepeatMode&&filePlaylist!=null)
                {
                    if(!Project34.a.isAlive() && !filePlaylist.isEmpty())
                    {
                        a = new Thread ()
                        {
                            public void run()
                            {  
                                try
                                {
                                    FileInputStream buff;
                                    if(filePlaylist.size()-1>=iterator)
                                    {
                                        fileCurrentlyPlaying = filePlaylist.get(iterator);
                                        buff = new FileInputStream(fileCurrentlyPlaying);
                                        iterator++;
                                        jTextFieldPlayingFile.setText(filePlaylist.get(iterator).getName());
                                    }
                                    else
                                    {
                                        iterator=0;
                                        fileCurrentlyPlaying = filePlaylist.get(iterator);
                                        buff = new FileInputStream(fileCurrentlyPlaying);
                                        jTextFieldPlayingFile.setText(filePlaylist.get(iterator).getName());
                                    }
                                    if(buff!=null)
                                    {
                                        myplayer = new Player(buff);
                                        if (myplayer != null)
                                        {
                                             myplayer.play();
                                             jTextFieldPlayingFile.setText("Playing: " + fileCurrentlyPlaying.getName());
                                        }
                                    }
                               }
                                catch(Exception e)
                                {
                                    System.out.printf("Error autoselection: %s\n", e);
                                } 
                            }

                        };
                         a.start();
                    }
                }
            }
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jDialog3 = new javax.swing.JDialog();
        jFrame1 = new javax.swing.JFrame();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jButtonPause = new javax.swing.JButton();
        jButtonPlay = new javax.swing.JButton();
        jButtonBrowse = new javax.swing.JButton();
        jButtonAddToPlaylist = new javax.swing.JButton();
        jButtonStop = new javax.swing.JButton();
        jButtonNextSong = new javax.swing.JButton();
        jButtonPrintPlaylist = new javax.swing.JButton();
        jTextFieldPlayingFile = new javax.swing.JTextField();
        jButtonPreviousSong = new javax.swing.JButton();
        jButtonRepeatMode = new javax.swing.JButton();
        jButtonShuffle = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListPlaylist = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jButtonDisplayPlaylist = new javax.swing.JButton();
        jButtonClearPlaylist = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java MP3 Player");
        setResizable(false);

        jButtonPause.setText("Pause");
        jButtonPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPauseActionPerformed(evt);
            }
        });

        jButtonPlay.setText("Play");
        jButtonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlayActionPerformed(evt);
            }
        });

        jButtonBrowse.setText("Browse");
        jButtonBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBrowseActionPerformed(evt);
            }
        });

        jButtonAddToPlaylist.setText("Add To Playlist");
        jButtonAddToPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddToPlaylistActionPerformed(evt);
            }
        });

        jButtonStop.setText("Stop");
        jButtonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStopActionPerformed(evt);
            }
        });

        jButtonNextSong.setText("Next Song");
        jButtonNextSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextSongActionPerformed(evt);
            }
        });

        jButtonPrintPlaylist.setText("Print Playlist");
        jButtonPrintPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintPlaylistActionPerformed(evt);
            }
        });

        jTextFieldPlayingFile.setEditable(false);
        jTextFieldPlayingFile.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldPlayingFile.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jTextFieldPlayingFile.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPlayingFile.setToolTipText("");
        jTextFieldPlayingFile.setAutoscrolls(false);
        jTextFieldPlayingFile.setEnabled(false);
        jTextFieldPlayingFile.setName(""); // NOI18N
        jTextFieldPlayingFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPlayingFileActionPerformed(evt);
            }
        });

        jButtonPreviousSong.setText("Previous Song");
        jButtonPreviousSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreviousSongActionPerformed(evt);
            }
        });

        jButtonRepeatMode.setText("Repeat Mode is ON!");
        jButtonRepeatMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRepeatModeActionPerformed(evt);
            }
        });

        jButtonShuffle.setText("Shuffle!");
        jButtonShuffle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShuffleActionPerformed(evt);
            }
        });

        jListPlaylist.setFocusable(false);
        jListPlaylist.setOpaque(false);
        jListPlaylist.setVerifyInputWhenFocusTarget(false);
        jScrollPane2.setViewportView(jListPlaylist);
        jListPlaylist.getAccessibleContext().setAccessibleName("");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("File Playing:");
        jLabel1.setEnabled(false);
        jLabel1.setFocusable(false);

        jButtonDisplayPlaylist.setText("Display Playlist");
        jButtonDisplayPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDisplayPlaylistActionPerformed(evt);
            }
        });

        jButtonClearPlaylist.setText("Clear Playlist");
        jButtonClearPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearPlaylistActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonPreviousSong)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonRepeatMode))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonPrintPlaylist)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonBrowse)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonNextSong))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextFieldPlayingFile, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButtonClearPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonDisplayPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonShuffle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButtonPlay)
                                .addGap(24, 24, 24)
                                .addComponent(jButtonPause)
                                .addGap(27, 27, 27)
                                .addComponent(jButtonStop)
                                .addGap(26, 26, 26)
                                .addComponent(jButtonAddToPlaylist)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldPlayingFile, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonShuffle)
                    .addComponent(jButtonDisplayPlaylist)
                    .addComponent(jButtonClearPlaylist))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPause)
                    .addComponent(jButtonAddToPlaylist)
                    .addComponent(jButtonPlay)
                    .addComponent(jButtonStop))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBrowse)
                    .addComponent(jButtonNextSong)
                    .addComponent(jButtonPrintPlaylist))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPreviousSong)
                    .addComponent(jButtonRepeatMode))
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void DrawPlaylist() 
    {
        String[] myString = new String[1000];
        int i=0;
        if( filePlaylist!=null)
        {
            for(File s : filePlaylist)
            {
                if(s!=null)
                {
                    myString[i] = s.getName();
                    i++;
                }
            }
        }
        jListPlaylist.setModel(new javax.swing.AbstractListModel<String>() {
            public int getSize() { return myString.length; }
            public String getElementAt(int i) { return myString[i]; }
        });

    }
    private void jButtonPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPauseActionPerformed
           if(a!=null)
           {
                if(this.jButtonPause.getText().compareTo("Pause")==0)
                {
                    this.jButtonPause.setText("Resume");
                     a.suspend();
                     if(fileCurrentlyPlaying!=null)
                     {
                        this.jTextFieldPlayingFile.setText("Paused on: " + fileCurrentlyPlaying.getName());
                     }
                }
                else
                {
                    this.jButtonPause.setText("Pause");
                    this.jTextFieldPlayingFile.setText("Playing: " + fileCurrentlyPlaying.getName());
                    a.resume();
                }
           }
    }//GEN-LAST:event_jButtonPauseActionPerformed

    private void PlaySongFile()
    {
        if(a!=null)
        {
            if(a.isAlive())
            {
                a.stop();
            }
        }
       a = new Thread ()
       {
           public void run()
           {  
               try
               {   
                   if(fileCurrentlyPlaying!=null)
                   {
                       FileInputStream buff = new FileInputStream(fileCurrentlyPlaying);
                       myplayer = new Player(buff);
                       if (myplayer != null)
                       {
                           jTextFieldPlayingFile.setText("Playing: " + fileCurrentlyPlaying.getName());
                           myplayer.play();
                           Browsed = false;
                       }
                   }
              }
               catch(Exception e)
               {
                   System.out.printf("Error Playing File: %s\n", e);
               } 
           }

       };
       a.start();
    }
    private void jButtonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlayActionPerformed
        // TODO add your handling code here:
        this.PlaySongFile();
    }//GEN-LAST:event_jButtonPlayActionPerformed
    private void ReadPlaylistFile()
    {
        if(filePlaylist!=null)
        {
            filePlaylist.clear();
            try{
               FileInputStream fi = new FileInputStream(playlistPhysicalFile);
               ObjectInputStream oi = new ObjectInputStream(fi);
               while(true) //this loop will terminate when the catch block will terminate, and the catch block will
                   //terminate then EOFException will be thrown.
               {
                   filePlaylist = (ArrayList) oi.readObject();
                     //this will read until the file ends. 
                  //When it cannot read any more object from the file it will throw an EOFException that needs
                 //to be catched, and handled, otherwise the program will terminate.

               }
           }
           catch(EOFException b) { }
           catch(IOException e) { }
           catch (ClassNotFoundException e) {}
            
        }
    }
    private void WritePlaylistFile()
    {
        if(filePlaylist!=null)
        {
            try{
                FileOutputStream fs = new FileOutputStream(playlistPhysicalFile);
                ObjectOutputStream os = new ObjectOutputStream(fs);
                os.writeObject(filePlaylist);
                os.close();
                fs.close();
            }
            catch(FileNotFoundException e)
            {
                System.out.printf("FileNotFoundException: %s\n", e);
            }
            catch(IOException e)
            {
                System.out.printf("IOException: %s\n", e);
            }
        }
    }
    private void jButtonBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBrowseActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
          fileCurrentlyPlaying = fileChooser.getSelectedFile();
          this.jTextFieldPlayingFile.setText("Selected: " + fileCurrentlyPlaying.getName());
          this.Browsed = true;
          // load from file
        }
    }//GEN-LAST:event_jButtonBrowseActionPerformed

    private void jButtonAddToPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddToPlaylistActionPerformed

        boolean GoFurther = true;
        this.ReadPlaylistFile(); //refresh the playlist.
        if(fileCurrentlyPlaying!=null)
        {
            if(filePlaylist==null)
            {
                filePlaylist = new ArrayList();
            }
            if(!filePlaylist.isEmpty())
            {
               for(File s : filePlaylist)
               {
                   if(s.compareTo(fileCurrentlyPlaying)==0)
                   {
                       GoFurther = false;
                       break;
                   }
               }
            }
            if(GoFurther)
                {
                    filePlaylist.add(fileCurrentlyPlaying);
                    this.WritePlaylistFile();
                    this.DrawPlaylist();
                }
                else
                {
                    System.out.printf("File: %s is already in the playlist.\n", fileCurrentlyPlaying.getName());
                }
        }
        else
        {
            System.out.printf("Please, select a file first!\n");
        }
    }//GEN-LAST:event_jButtonAddToPlaylistActionPerformed

    private void jButtonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopActionPerformed
        if(a!=null)
        {
            a.suspend();
            jTextFieldPlayingFile.setText("Stopped on: " + fileCurrentlyPlaying.getName());
        }
    }//GEN-LAST:event_jButtonStopActionPerformed

    private void jButtonNextSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextSongActionPerformed
        if(fileCurrentlyPlaying!=null && !filePlaylist.isEmpty())
        {
            boolean selectionDone = false;
            for(File s: filePlaylist)
            {
                if(s.compareTo(fileCurrentlyPlaying)==0)
                {
                    int futureIndex = filePlaylist.indexOf(s);
                    if(futureIndex<filePlaylist.size()-1)
                    {
                        fileCurrentlyPlaying = filePlaylist.get(futureIndex+1);
                    }
                    else
                    {
                        fileCurrentlyPlaying = filePlaylist.get(0);
                    }
                    selectionDone = true;
                    break;
                }
            }
            if(!selectionDone)
            {
                fileCurrentlyPlaying = filePlaylist.get(0);
            }
        }
        if(a!=null && fileCurrentlyPlaying!=null)
        {
            this.PlaySongFile();
        }
    }//GEN-LAST:event_jButtonNextSongActionPerformed

    private void jButtonPrintPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintPlaylistActionPerformed
        this.ReadPlaylistFile();
        
        if(filePlaylist!=null && !filePlaylist.isEmpty())
        {
            System.out.printf("Playlist Content: \n\n");
            for(File s: filePlaylist)
            {
                if(s!=null)
                {
                    System.out.printf("%s\n", s.getName());
                }
            }
            System.out.printf("\nThere are %d songs in the playlist.\n", filePlaylist.size());
        }
        else
        {
            System.out.printf("Playlist is empty!\n");
        }
    }//GEN-LAST:event_jButtonPrintPlaylistActionPerformed

    private void jTextFieldPlayingFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPlayingFileActionPerformed

    }//GEN-LAST:event_jTextFieldPlayingFileActionPerformed

    private void jButtonPreviousSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreviousSongActionPerformed

        if(fileCurrentlyPlaying!=null && !filePlaylist.isEmpty())
        {
            boolean selectionDone = false;
            for(File s: filePlaylist)
            {
                if(s.compareTo(fileCurrentlyPlaying)==0)
                {
                    int futureIndex = filePlaylist.indexOf(s)-1;
                    if(futureIndex<0)
                    {
                        int index = filePlaylist.size()-1;
                        fileCurrentlyPlaying = filePlaylist.get(index);
                    }
                    else if(futureIndex<filePlaylist.size()-1)
                    {
                        int index = futureIndex;
                        fileCurrentlyPlaying = filePlaylist.get(futureIndex);
                    }
                    selectionDone = true;
                    break;
                }
            }
            if(!selectionDone)
            {
                fileCurrentlyPlaying = filePlaylist.get(0);
            }
        }
        if(a!=null && fileCurrentlyPlaying!=null)
        {
            this.PlaySongFile();
        }
    }//GEN-LAST:event_jButtonPreviousSongActionPerformed

    private void jButtonRepeatModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRepeatModeActionPerformed
        if(this.jButtonRepeatMode.getText().compareTo("Repeat Mode is ON!")==0)
        {
            this.jButtonRepeatMode.setText("Repeat Mode is OFF!");
            Project34.RepeatMode = false;
        }
        else
        {
            this.jButtonRepeatMode.setText("Repeat Mode is ON!");
            Project34.RepeatMode = true;
        }
    }//GEN-LAST:event_jButtonRepeatModeActionPerformed

    private void jButtonShuffleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShuffleActionPerformed
        if(filePlaylist!=null)
        {
            Random rnd = new Random();
            if(filePlaylist.size()>2)
            {
                int choice = rnd.nextInt(filePlaylist.size());
                fileCurrentlyPlaying = filePlaylist.get(choice);
                this.PlaySongFile();
            }
            else
            {
                System.out.printf("You cannot shuffle a playlist with less than 3 songs.\n");
            }
        }
    }//GEN-LAST:event_jButtonShuffleActionPerformed

    private void jButtonDisplayPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDisplayPlaylistActionPerformed
        if(this.jButtonDisplayPlaylist.getText().compareTo("Display Playlist")==0)
        {
            this.setSize(695, 288);
            this.jButtonDisplayPlaylist.setText("Hide Playlist");
        }
        else
        {
            this.setSize(377, 288);
            this.jButtonDisplayPlaylist.setText("Display Playlist");
        }
    }//GEN-LAST:event_jButtonDisplayPlaylistActionPerformed

    private void jButtonClearPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearPlaylistActionPerformed
        if(filePlaylist!=null)
        {
            filePlaylist.clear();
            this.WritePlaylistFile();
            this.DrawPlaylist();
        }
    }//GEN-LAST:event_jButtonClearPlaylistActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Project34.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Project34.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Project34.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Project34.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Project34().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddToPlaylist;
    private javax.swing.JButton jButtonBrowse;
    private javax.swing.JButton jButtonClearPlaylist;
    private javax.swing.JButton jButtonDisplayPlaylist;
    private javax.swing.JButton jButtonNextSong;
    private javax.swing.JButton jButtonPause;
    private javax.swing.JButton jButtonPlay;
    private javax.swing.JButton jButtonPreviousSong;
    private javax.swing.JButton jButtonPrintPlaylist;
    private javax.swing.JButton jButtonRepeatMode;
    private javax.swing.JButton jButtonShuffle;
    private javax.swing.JButton jButtonStop;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jListPlaylist;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextFieldPlayingFile;
    // End of variables declaration//GEN-END:variables
}
