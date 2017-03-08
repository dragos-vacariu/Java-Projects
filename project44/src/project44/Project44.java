/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project44;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author Black2
 */
public class Project44 extends javax.swing.JFrame {

    /**
     */
    private final ArrayList<Car> AllCars;
    private final CarLot CarShop;
    private final Track Drag;
    private Timer timer;
    private Player gamePlayer;
    private final Garage gameGarage = new Garage();
    private GameOpponents Rival;
    private boolean enteredCarLot;
    private boolean enteredPlayerStats;
    private boolean enteredGarage;
    private boolean enteredGarageEngines;
    private boolean enteredGarageTurbos;
    private boolean enteredGarageNitrous;
    private boolean enteredGarageTransmissions;
    private boolean enteredSafeHouse;
    private boolean enteredPlaceBet;
    private boolean enteredMainMenuInfo;
    private boolean enteredGamePlay;
    private boolean gamePlayRunning;
    private boolean enteredMenuLoadGame;
    private boolean betSet;
    private float timeCounter;
    private int carLotIndex;
    private int betPrize;
    private int RacePrize;
    private int BetFactor;
    private int safehousePlayerCarIndex;
    private int TrafficAvoider;
    private final Random rand = new Random();
    private final File PlayerSaveGame = new File("player.gam");
    private final File PlayerSaveGame2 = new File("player2.gam");
    private final File PlayerSaveGame3 = new File("player3.gam");

    public Project44() {
        initComponents();
        TrafficAvoider=0;
        getContentPane().add(jLabelCar1Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));
        getContentPane().add(jLabelPlayerCarIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 305, -1, -1));
        getContentPane().add(jLabelDisplayWinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 201, -1, 48));    
        this.enteredCarLot = false;
        this.enteredPlayerStats = false;
        this.enteredGarage = false;
        this.enteredGarageEngines = false;
        this.enteredGarageTransmissions = false;
        this.enteredGarageTurbos = false;
        this.enteredGarageNitrous = false;
        this.enteredSafeHouse = false;
        this.enteredPlaceBet = false;
        this.enteredMainMenuInfo = false;
        this.enteredGamePlay = false;
        this.gamePlayRunning = false;
        this.enteredMenuLoadGame = false;
        this.betSet = false;
        carLotIndex = 0;
        this.betPrize = 0;
        this.BetFactor = 0;
        this.RacePrize = 0;
        this.timeCounter = 0;
        safehousePlayerCarIndex=0;
        CarShop = new CarLot();
        this.AllCars = CarShop.getAllCars();
        Drag = new Track("Highway", 100f);
        jLabelFinish.setVisible(false);
        this.jLabelPlayerWarning.setText("");
        //Disabling controls:
        this.jButtonCollisionControlLeft.setEnabled(false);
        this.jButtonCollisionControlRight.setEnabled(false);
        this.jButtonCollisionControlUp.setEnabled(false);
        this.jButtonShiftSync1.setEnabled(false);
        this.jButtonShiftSync2.setEnabled(false);
        this.jButtonShiftSync3.setEnabled(false);
        //Hiding Gameplay buttons;
        this.jButtonGarage.setVisible(false);
        this.jButtonStartRace.setVisible(false);
        this.jLabelFinish.setVisible(false);
        this.jLabelSpeedSpecCar1.setVisible(false);
        this.jLabelAccSpecCar1.setVisible(false);
        this.jLabelSpeedSpecCarPlayer.setVisible(false);
        this.jLabelAccSpecCarPlayer.setVisible(false);
        this.jLabelTableStatsCar2.setVisible(false);
        this.jLabelTableStatsCar1.setVisible(false);
        this.jLabelSpeedSpecCar1.setVisible(false);
        this.jLabelAccSpecCar1.setVisible(false);
        this.jLabelCar1Icon.setVisible(false);
        this.jLabelPlayerCarIcon.setVisible(false);
        this.jLabelCar2RacingStats.setVisible(false);
        this.jLabelCar1RacingStats.setVisible(false);
        this.jLabelDisplayWinner.setVisible(false);
        this.jProgressBarCar1.setVisible(false);
        this.jProgressBarCar2.setVisible(false);
        this.jLabelCarName1.setVisible(false);
        this.jLabelCarName2.setVisible(false);
        this.jLabelPlayerMoney.setVisible(false);
        this.jLabelCPUOpponentName.setVisible(false);
        this.jButtonCollisionControlLeft.setVisible(false);
        this.jButtonCollisionControlRight.setVisible(false);
        this.jButtonCollisionControlUp.setVisible(false);
        this.jButtonShiftSync1.setVisible(false);
        this.jButtonShiftSync2.setVisible(false);
        this.jButtonShiftSync3.setVisible(false);
        this.jLabelShiftSyncronizerTab.setVisible(false);
        this.jLabelCollisionControlTab.setVisible(false);
        this.jLabelPlayer.setVisible(false);
        this.jLabelPlayerWarning.setVisible(false);
        this.jLabelDriverXP.setVisible(false);
        this.jLabelPlayerXP.setVisible(false);
        this.jLabelRacesToGo.setVisible(false);
        this.jButtonNextRival.setVisible(false);
        this.jButtonPreviousRival.setVisible(false);
        this.jLabelCPURivalLosses.setVisible(false);
        this.jLabelCPURivalWins.setVisible(false);
        this.jButtonPlaceBet.setVisible(false);
        this.jLabelRacePrize.setVisible(false);
        this.jLabelBetPrize.setVisible(false);
        this.jTextFieldProfileName.setVisible(false);
        //CatLot Stuff:
        this.jButtonCarLotNext.setVisible(false);
        this.jButtonCarLotPrevious.setVisible(false);
        this.jLabelCarLotSpecs.setVisible(false);
        this.jLabelCarLotContent.setVisible(false);
        this.jButtonCarLot.setVisible(false);
        this.jLabelCarLotName.setVisible(false);
        this.jLabelCarLotPrice.setVisible(false);
        this.jButtonCarLotBuy.setVisible(false);
        //PlayerStats Stuff
        this.jLabelPlayerStatsCollisions.setVisible(false);
        this.jLabelPlayerStatsRacesWon.setVisible(false);
        this.jLabelPlayerStatsRacesLost.setVisible(false);
        this.jLabelPlayerStatsRacesDrawed.setVisible(false);
        this.jLabelPlayerStatsPerfectShifts.setVisible(false);
        this.jButtonPlayerStats.setVisible(false);
        //Garage Stuff
        this.jButtonGarageEngines.setVisible(false);
        this.jButtonGarageNitrous.setVisible(false);
        this.jButtonGarageTurbos.setVisible(false);
        this.jButtonGarageTransm.setVisible(false);
        this.jLabelGaragePlayerNitrousLevel.setVisible(false);
        this.jLabelGaragePlayerTurboLevel.setVisible(false);
        this.jLabelGaragePlayerEngineLevel.setVisible(false);
        this.jLabelGaragePlayerTransmLevel.setVisible(false);
        this.jLabelGaragePartsInfo.setVisible(false);
        this.jButtonSafeHouse.setVisible(false);
        //Menu Stuff
        this.jLabelMainMenuInfoLabel.setVisible(false);
        this.jButtonLoadSaveGameNum1.setVisible(false);
        this.jButtonLoadSaveGameNum2.setVisible(false);
        this.jButtonLoadSaveGameNum3.setVisible(false);
        this.jButtonLoadSaveGameNum1.setEnabled(false);
        this.jButtonLoadSaveGameNum2.setEnabled(false);
        this.jButtonLoadSaveGameNum3.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelCar1Icon = new javax.swing.JLabel();
        jLabelPlayerCarIcon = new javax.swing.JLabel();
        jButtonStartRace = new javax.swing.JButton();
        jProgressBarCar1 = new javax.swing.JProgressBar();
        jProgressBarCar2 = new javax.swing.JProgressBar();
        jLabelFinish = new javax.swing.JLabel();
        jLabelCarName2 = new javax.swing.JLabel();
        jLabelCarName1 = new javax.swing.JLabel();
        jLabelTableStatsCar2 = new javax.swing.JLabel();
        jLabelTableStatsCar1 = new javax.swing.JLabel();
        jLabelCar2RacingStats = new javax.swing.JLabel();
        jButtonGarage = new javax.swing.JButton();
        jLabelDisplayWinner = new javax.swing.JLabel();
        jLabelSpeedSpecCar1 = new javax.swing.JLabel();
        jLabelAccSpecCar1 = new javax.swing.JLabel();
        jLabelSpeedSpecCarPlayer = new javax.swing.JLabel();
        jLabelAccSpecCarPlayer = new javax.swing.JLabel();
        jButtonMainMenuQuit = new javax.swing.JButton();
        jLabelCar1RacingStats = new javax.swing.JLabel();
        jButtonMainMenuNewGame = new javax.swing.JButton();
        jButtonCarLot = new javax.swing.JButton();
        jLabelCarLotContent = new javax.swing.JLabel();
        jButtonCarLotNext = new javax.swing.JButton();
        jButtonCarLotPrevious = new javax.swing.JButton();
        jLabelCarLotSpecs = new javax.swing.JLabel();
        jLabelCarLotName = new javax.swing.JLabel();
        jLabelCarLotPrice = new javax.swing.JLabel();
        jButtonCarLotBuy = new javax.swing.JButton();
        jButtonMainMenuLoadGame = new javax.swing.JButton();
        jLabelCPUOpponentName = new javax.swing.JLabel();
        jLabelPlayerMoney = new javax.swing.JLabel();
        jButtonCollisionControlLeft = new javax.swing.JButton();
        jButtonCollisionControlRight = new javax.swing.JButton();
        jButtonCollisionControlUp = new javax.swing.JButton();
        jButtonShiftSync3 = new javax.swing.JButton();
        jButtonShiftSync2 = new javax.swing.JButton();
        jButtonShiftSync1 = new javax.swing.JButton();
        jLabelCollisionControlTab = new javax.swing.JLabel();
        jLabelShiftSyncronizerTab = new javax.swing.JLabel();
        jLabelPlayer = new javax.swing.JLabel();
        jLabelPlayerWarning = new javax.swing.JLabel();
        jButtonPlayerStats = new javax.swing.JButton();
        jLabelPlayerStatsCollisions = new javax.swing.JLabel();
        jLabelPlayerStatsPerfectShifts = new javax.swing.JLabel();
        jLabelPlayerStatsRacesWon = new javax.swing.JLabel();
        jLabelPlayerStatsRacesLost = new javax.swing.JLabel();
        jLabelPlayerStatsRacesDrawed = new javax.swing.JLabel();
        jLabelGaragePlayerEngineLevel = new javax.swing.JLabel();
        jLabelGaragePlayerTurboLevel = new javax.swing.JLabel();
        jLabelGaragePlayerNitrousLevel = new javax.swing.JLabel();
        jLabelGaragePlayerTransmLevel = new javax.swing.JLabel();
        jButtonGarageEngines = new javax.swing.JButton();
        jButtonGarageTurbos = new javax.swing.JButton();
        jButtonGarageTransm = new javax.swing.JButton();
        jButtonGarageNitrous = new javax.swing.JButton();
        jLabelGaragePartsInfo = new javax.swing.JLabel();
        jButtonSafeHouse = new javax.swing.JButton();
        jLabelDriverXP = new javax.swing.JLabel();
        jLabelPlayerXP = new javax.swing.JLabel();
        jLabelRacesToGo = new javax.swing.JLabel();
        jButtonPreviousRival = new javax.swing.JButton();
        jButtonNextRival = new javax.swing.JButton();
        jLabelCPURivalWins = new javax.swing.JLabel();
        jLabelCPURivalLosses = new javax.swing.JLabel();
        jButtonPlaceBet = new javax.swing.JButton();
        jLabelRacePrize = new javax.swing.JLabel();
        jLabelBetPrize = new javax.swing.JLabel();
        jButtonMainMenuInfo = new javax.swing.JButton();
        jLabelMainMenuInfoLabel = new javax.swing.JLabel();
        jLabelDragRacingLogo = new javax.swing.JLabel();
        jButtonLoadSaveGameNum3 = new javax.swing.JButton();
        jButtonLoadSaveGameNum1 = new javax.swing.JButton();
        jButtonLoadSaveGameNum2 = new javax.swing.JButton();
        jTextFieldProfileName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DragRacingSim");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCar1Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCar1Icon.setToolTipText("");
        jLabelCar1Icon.setFocusable(false);
        jLabelCar1Icon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabelCar1Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 11, -1, -1));

        jLabelPlayerCarIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPlayerCarIcon.setToolTipText("");
        jLabelPlayerCarIcon.setFocusable(false);
        jLabelPlayerCarIcon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabelPlayerCarIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 305, -1, -1));

        jButtonStartRace.setText("Start Race");
        jButtonStartRace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartRaceActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonStartRace, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, -1, -1));
        getContentPane().add(jProgressBarCar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 480, -1));
        getContentPane().add(jProgressBarCar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 400, 480, -1));

        jLabelFinish.setFont(new java.awt.Font("Square721 BT", 0, 18)); // NOI18N
        jLabelFinish.setText("FINISH");
        getContentPane().add(jLabelFinish, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, -1, -1));

        jLabelCarName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCarName2.setText("jLabel2");
        getContentPane().add(jLabelCarName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 440, -1));

        jLabelCarName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCarName1.setText("jLabel2");
        jLabelCarName1.setToolTipText("");
        getContentPane().add(jLabelCarName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 420, -1));

        jLabelTableStatsCar2.setForeground(new java.awt.Color(0, 102, 0));
        jLabelTableStatsCar2.setText("Perfect Shifts         Drafts         Collisions       CurrentSpeed        Progress          Time");
        getContentPane().add(jLabelTableStatsCar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 350, 500, -1));

        jLabelTableStatsCar1.setForeground(new java.awt.Color(0, 102, 0));
        jLabelTableStatsCar1.setText("Perfect Shifts         Drafts         Collisions       CurrentSpeed        Progress        Time");
        getContentPane().add(jLabelTableStatsCar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 460, -1));

        jLabelCar2RacingStats.setFont(new java.awt.Font("Perpetua", 0, 14)); // NOI18N
        jLabelCar2RacingStats.setForeground(new java.awt.Color(204, 0, 204));
        jLabelCar2RacingStats.setText("        0                          0                      0                        0                          0                         0");
        getContentPane().add(jLabelCar2RacingStats, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 375, 490, -1));

        jButtonGarage.setText("Garage");
        jButtonGarage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGarageActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGarage, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 630, -1, -1));

        jLabelDisplayWinner.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jLabelDisplayWinner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabelDisplayWinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 481, -1, 48));

        jLabelSpeedSpecCar1.setText("Top Speed:");
        getContentPane().add(jLabelSpeedSpecCar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabelAccSpecCar1.setText("Acceleration:");
        getContentPane().add(jLabelAccSpecCar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 188, -1, -1));

        jLabelSpeedSpecCarPlayer.setText("Top Speed:");
        getContentPane().add(jLabelSpeedSpecCarPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 424, -1, -1));

        jLabelAccSpecCarPlayer.setText("Acceleration:");
        getContentPane().add(jLabelAccSpecCarPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 442, -1, -1));

        jButtonMainMenuQuit.setText("QUIT");
        jButtonMainMenuQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMainMenuQuitActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMainMenuQuit, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 630, -1, -1));

        jLabelCar1RacingStats.setFont(new java.awt.Font("Perpetua", 0, 14)); // NOI18N
        jLabelCar1RacingStats.setForeground(new java.awt.Color(204, 0, 204));
        jLabelCar1RacingStats.setText("        0                          0                      0                        0                          0                       0");
        getContentPane().add(jLabelCar1RacingStats, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 500, -1));

        jButtonMainMenuNewGame.setText("NEW GAME");
        jButtonMainMenuNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMainMenuNewGameActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMainMenuNewGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 630, 94, -1));

        jButtonCarLot.setText("Car Lot");
        jButtonCarLot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCarLotActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCarLot, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 630, -1, -1));
        getContentPane().add(jLabelCarLotContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 226, 157));

        jButtonCarLotNext.setText("Next");
        jButtonCarLotNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCarLotNextActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCarLotNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 217, -1, -1));

        jButtonCarLotPrevious.setText("Previous");
        jButtonCarLotPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCarLotPreviousActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCarLotPrevious, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, -1));

        jLabelCarLotSpecs.setText("Car Specs:");
        getContentPane().add(jLabelCarLotSpecs, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 325, 340, -1));

        jLabelCarLotName.setText("Name:");
        getContentPane().add(jLabelCarLotName, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));

        jLabelCarLotPrice.setText("Price:");
        getContentPane().add(jLabelCarLotPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 300, 170, -1));

        jButtonCarLotBuy.setText("Buy!");
        jButtonCarLotBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCarLotBuyActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCarLotBuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 420, 90, -1));

        jButtonMainMenuLoadGame.setText("LOAD GAME");
        jButtonMainMenuLoadGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMainMenuLoadGameActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMainMenuLoadGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 630, 111, -1));

        jLabelCPUOpponentName.setText("Opponent:");
        getContentPane().add(jLabelCPUOpponentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, -1));

        jLabelPlayerMoney.setText("Money:");
        getContentPane().add(jLabelPlayerMoney, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 477, -1, -1));

        jButtonCollisionControlLeft.setBackground(new java.awt.Color(255, 0, 0));
        jButtonCollisionControlLeft.setText("<-");
        jButtonCollisionControlLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCollisionControlLeftActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCollisionControlLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 520, 44, -1));

        jButtonCollisionControlRight.setBackground(new java.awt.Color(255, 0, 0));
        jButtonCollisionControlRight.setText("->");
        jButtonCollisionControlRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCollisionControlRightActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCollisionControlRight, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 520, 44, -1));

        jButtonCollisionControlUp.setBackground(new java.awt.Color(255, 0, 0));
        jButtonCollisionControlUp.setText("^");
        jButtonCollisionControlUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCollisionControlUpActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCollisionControlUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 520, 44, -1));

        jButtonShiftSync3.setBackground(new java.awt.Color(0, 0, 255));
        jButtonShiftSync3.setText("Sync3");
        jButtonShiftSync3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShiftSync3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonShiftSync3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 520, -1, -1));

        jButtonShiftSync2.setBackground(new java.awt.Color(0, 0, 255));
        jButtonShiftSync2.setText("Sync2");
        jButtonShiftSync2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShiftSync2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonShiftSync2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 520, -1, -1));

        jButtonShiftSync1.setBackground(new java.awt.Color(0, 0, 255));
        jButtonShiftSync1.setText("Sync1");
        jButtonShiftSync1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShiftSync1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonShiftSync1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 520, -1, -1));

        jLabelCollisionControlTab.setBackground(new java.awt.Color(255, 0, 0));
        jLabelCollisionControlTab.setForeground(new java.awt.Color(255, 0, 0));
        jLabelCollisionControlTab.setText("Collision Control");
        getContentPane().add(jLabelCollisionControlTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 490, 100, 20));

        jLabelShiftSyncronizerTab.setBackground(new java.awt.Color(0, 0, 255));
        jLabelShiftSyncronizerTab.setForeground(new java.awt.Color(0, 0, 255));
        jLabelShiftSyncronizerTab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelShiftSyncronizerTab.setText("Shift Syncronizer:");
        getContentPane().add(jLabelShiftSyncronizerTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 490, 310, -1));

        jLabelPlayer.setText("Player:");
        getContentPane().add(jLabelPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 285, -1, -1));

        jLabelPlayerWarning.setText("jLabel1");
        getContentPane().add(jLabelPlayerWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, 300, -1));

        jButtonPlayerStats.setText("Player Stats");
        jButtonPlayerStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlayerStatsActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPlayerStats, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 630, -1, -1));

        jLabelPlayerStatsCollisions.setText("PlayerStatsCollisions");
        getContentPane().add(jLabelPlayerStatsCollisions, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 210, -1));

        jLabelPlayerStatsPerfectShifts.setText("PlayerStatsPerfectShifts");
        getContentPane().add(jLabelPlayerStatsPerfectShifts, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 240, -1));

        jLabelPlayerStatsRacesWon.setText("PlayerStatsRacesWon");
        getContentPane().add(jLabelPlayerStatsRacesWon, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 350, -1));

        jLabelPlayerStatsRacesLost.setText("PlayerStatsRacesLost");
        getContentPane().add(jLabelPlayerStatsRacesLost, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 410, -1));

        jLabelPlayerStatsRacesDrawed.setText("lPlayerStatsRacesDrawed");
        getContentPane().add(jLabelPlayerStatsRacesDrawed, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 430, -1));

        jLabelGaragePlayerEngineLevel.setText("GaragePlayerEngineLevel");
        getContentPane().add(jLabelGaragePlayerEngineLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 132, 190, 20));

        jLabelGaragePlayerTurboLevel.setText("GaragePlayerTurboLevel");
        getContentPane().add(jLabelGaragePlayerTurboLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 182, 190, -1));

        jLabelGaragePlayerNitrousLevel.setText("GaragePlayerNitrousLevel");
        getContentPane().add(jLabelGaragePlayerNitrousLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 190, -1));

        jLabelGaragePlayerTransmLevel.setText("GaragePlayerTransmLevel");
        getContentPane().add(jLabelGaragePlayerTransmLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 163, 200, 20));

        jButtonGarageEngines.setText("Engine Packs");
        jButtonGarageEngines.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGarageEnginesActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGarageEngines, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 210, -1));

        jButtonGarageTurbos.setText("Turbo Packs");
        jButtonGarageTurbos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGarageTurbosActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGarageTurbos, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, 210, -1));

        jButtonGarageTransm.setText("Transmission Packs");
        jButtonGarageTransm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGarageTransmActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGarageTransm, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 210, -1));

        jButtonGarageNitrous.setText("Nitrous Packs");
        jButtonGarageNitrous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGarageNitrousActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGarageNitrous, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 210, -1));

        jLabelGaragePartsInfo.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        jLabelGaragePartsInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelGaragePartsInfo.setText("<html>\nPerformance Packs Information:\n<br>\n &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160;\n &#160; &#160; &#160; &#160;Acceleration:&#160; &#160; &#160; &#160;Top Speed:\n<br>\nEngine Level 1: &#160; &#160; &#160; &#160; &#160; &#160;&#160;   +0   &#160; &#160; &#160; &#160; &#160; &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;   +15\n<br>\nEngine Level 2:&#160; &#160; &#160; &#160; &#160; &#160;&#160;   +0   &#160; &#160; &#160; &#160; &#160; &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;   +35\n<br>\nEngine Level 3:&#160; &#160; &#160; &#160; &#160; &#160;&#160;   +0  &#160; &#160; &#160; &#160; &#160; &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;   +50\n<br>\n<br>\nTurbo Level 1:&#160; &#160; &#160; &#160; &#160; &#160;&#160;   +0.07   &#160; &#160; &#160; &#160; &#160; &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;   +0\n<br>\nTurbo Level 2:&#160; &#160; &#160; &#160; &#160; &#160;&#160;   +0.13   &#160; &#160; &#160; &#160; &#160; &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;   +0\n<br>\nTurbo Level 3:&#160; &#160; &#160; &#160; &#160; &#160;&#160;   +0.19   &#160; &#160; &#160; &#160; &#160; &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;   +0\n<br>\n<br>\nNitrous Level 1:&#160; &#160; &#160; &#160; &#160; &#160;&#160;   +0.02   &#160; &#160; &#160; &#160; &#160; &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;   +10\n<br>\nNitrous Level 2:&#160; &#160; &#160; &#160; &#160; &#160;&#160;   +0.04   &#160; &#160; &#160; &#160; &#160; &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;   +15\n<br>\nNitrous Level 3:&#160; &#160; &#160; &#160; &#160; &#160;&#160;   +0.055   &#160; &#160; &#160; &#160; &#160; &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;   +22\n<br>\n<br>\nTransm Level 1:&#160; &#160; &#160; &#160; &#160;   + 0.01   &#160; &#160; &#160; &#160; &#160; &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160&#160   +5\n<br>\nTransm Level 2:&#160; &#160; &#160; &#160; &#160;  +0.03   &#160; &#160; &#160; &#160; &#160; &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160&#160   +8\n<br>\nTransm Level 3: &#160; &#160; &#160; &#160; &#160;   +0.045   &#160; &#160; &#160; &#160; &#160; &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;   +12\n</html>");
        getContentPane().add(jLabelGaragePartsInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 270, 380));

        jButtonSafeHouse.setText("SafeHouse");
        jButtonSafeHouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSafeHouseActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSafeHouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 630, -1, -1));

        jLabelDriverXP.setText("Driver XP: ");
        getContentPane().add(jLabelDriverXP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 206, 90, -1));

        jLabelPlayerXP.setText("Player XP:");
        getContentPane().add(jLabelPlayerXP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 90, -1));

        jLabelRacesToGo.setText("Races to go:");
        getContentPane().add(jLabelRacesToGo, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 310, 120, -1));

        jButtonPreviousRival.setText("Previous Rival");
        jButtonPreviousRival.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreviousRivalActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPreviousRival, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 110, -1));

        jButtonNextRival.setText("Next Rival");
        jButtonNextRival.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextRivalActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNextRival, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 600, 110, -1));

        jLabelCPURivalWins.setText("Wins:");
        getContentPane().add(jLabelCPURivalWins, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 222, 80, -1));

        jLabelCPURivalLosses.setText("Losses:");
        getContentPane().add(jLabelCPURivalLosses, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 238, 70, -1));

        jButtonPlaceBet.setText("Place Bet");
        jButtonPlaceBet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlaceBetActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPlaceBet, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 600, -1, -1));

        jLabelRacePrize.setText("Race Prize:");
        getContentPane().add(jLabelRacePrize, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 330, 110, -1));

        jLabelBetPrize.setText("Bet Prize:");
        getContentPane().add(jLabelBetPrize, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 350, 100, -1));

        jButtonMainMenuInfo.setText("INFO");
        jButtonMainMenuInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMainMenuInfoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMainMenuInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 630, -1, -1));

        jLabelMainMenuInfoLabel.setText("<html>\nINFORMATIONS:\n<br>\nThis game was developed in JAVA using NetBeans 8.2 IDE and java.Swing GUI Interface.\n<br>\nGameplay:<br><br>\nDrag racing simulator is game trying soft simulating race behaviour between 2 cars with<br>\ndifferent characteristics such as, top speed, acceleration, driving skills, tunning and so on.\n<br>\nAbout Perfect Shifts:<br>\nIn racing a perfect shift is the ability of gearing at a proper time, in this game this will give you<br>\n0.1 points of acceleration and +5 current speed boost until the end of the race.\n<br>\nAbout Collisions:<br>\nIn this game a collision is the impact that the car has with the traffic, a collisions will decrease your<br> \ncurrent speed with 20 - 60 KmH and your acceleration with 0.02 points until the end of the race.\n<br>\nAbout Bets:<br>\nPlacing a bet is one way to earn money, the amount of money that you can bet on, depends on the<br>\npersonal records that the player and a particular driver had: wins vs losses contrast. Wins might raise<br> \nthe prize of a bet, and losses might lower the prize of bet. Wins and Losses are indicated under each<br>\ndifferent opponents, and losses -> indicates the amount of times that the player defetead him, <br>\nwins -> indicates the amount of times that the opponent defetead the player.\n<br>\nAbout Racing Prize:<br>\nRace prizes depends on the driver experience and also the person records that the player had with him.\n<br>\nAbout Player: <br>\nThe player can hold an unlimited amount of cars, and money up to billions.\n<br>\nCarreer Completion:\n<br>\nTo complete the game you have to defeat all your opponents in a 1 vs 1 challenge. Defeating an opponent<br>\nand completing the challenge implies winning 2 out of 3 races against the opponent. If the opponent wins <br>\n2 succesive races then your racord will be reset such that you will have to challenge him again.<br>\nThe total number of opponents that this game have is 110, they all have different personalities with <br>\ndifferent cars and characteristics <br>\nTuning Cars:\n<br>Tuning a car can be made using the Garage, the are different packages of parts which will increase your <br>\nperformance.\n<br>\nPlayer Experience<br>\nThe amount of experience that the player gains it mostly depends on the perfomance shown on the track, more <br>\ncollisions less amount of experience, more perfect shifts, higher amount of experience, defeating high-skilled drivers, <br>\nalso increases player's experience. Experience help the player have less to deal with the traffic, so there will be less<br>\ninterferance with the traffic and less crashes.\n</html>");
        getContentPane().add(jLabelMainMenuInfoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabelDragRacingLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project44/logo.png"))); // NOI18N
        jLabelDragRacingLogo.setToolTipText("");
        getContentPane().add(jLabelDragRacingLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 440, 400));

        jButtonLoadSaveGameNum3.setText("SaveGame 3");
        jButtonLoadSaveGameNum3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadSaveGameNum3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLoadSaveGameNum3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 580, 330, -1));

        jButtonLoadSaveGameNum1.setText("SaveGame 1");
        jButtonLoadSaveGameNum1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadSaveGameNum1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLoadSaveGameNum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 520, 330, -1));

        jButtonLoadSaveGameNum2.setText("SaveGame 2");
        jButtonLoadSaveGameNum2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadSaveGameNum2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLoadSaveGameNum2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 550, 330, -1));

        jTextFieldProfileName.setText("Name");
        jTextFieldProfileName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProfileNameActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldProfileName, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 490, 140, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonStartRaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartRaceActionPerformed
        if(this.jButtonStartRace.getText()=="Start Race")
        {
            this.CarRacing();
            this.jButtonGarage.setEnabled(false);
            this.jButtonCarLot.setEnabled(false);
            this.jButtonPlaceBet.setEnabled(false);
            this.jButtonStartRace.setEnabled(false);
            this.jButtonMainMenuNewGame.setEnabled(false);
            if(gamePlayer.getCurrentOpponentIndex()>0)
            {
                this.jButtonNextRival.setEnabled(false);
                this.jButtonPreviousRival.setEnabled(false);
                this.jButtonPlayerStats.setEnabled(false);
            }
            this.jButtonSafeHouse.setEnabled(false);
            this.jButtonPlayerStats.setEnabled(false);
            this.jLabelPlayerWarning.setText("");
        }
        else if(this.jButtonStartRace.getText()=="Continue")
        {
            timeCounter = 0;
            jProgressBarCar1.setValue(0);
            jProgressBarCar2.setValue(0);
            jLabelCar2RacingStats.setText(String.valueOf(0));
            jLabelDisplayWinner.setText("");
            jLabelCar2RacingStats.setText("        0                          0                      "+
                    "0                        0                          0                         0");
            jLabelCar1RacingStats.setText("        0                          0                      "+
                    "0                        0                          0                         0");
            jLabelPlayerWarning.setText("");
            this.jButtonStartRace.setText("Start Race");
            this.jButtonGarage.setEnabled(true);
            this.jButtonCarLot.setEnabled(true);
            this.jButtonPlayerStats.setEnabled(true);
            this.jButtonMainMenuNewGame.setEnabled(true);
            if(gamePlayer.getCurrentOpponentIndex()>0)
            {
                this.jButtonNextRival.setEnabled(true);
                this.jButtonPreviousRival.setEnabled(true);
            }
            this.jButtonPlayerStats.setEnabled(true);
            this.jButtonPlayerStats.setEnabled(true);
            this.jButtonSafeHouse.setEnabled(true);
            this.jButtonPlaceBet.setEnabled(true);
            boolean result = this.Rival.processInformation(gamePlayer);
            this.jLabelRacesToGo.setText("Races to go: " + String.valueOf(2-Rival.getPlayerWonTimes()));
            Rival.getOpponentCar().Reset();
            gamePlayer.getPlayerCar().Reset();
            Drag.Reset();
            if( result && gamePlayer.getIndexOf(Rival.getOpponentName())==gamePlayer.getCurrentOpponentIndex())
            {
                //Player opponents stuff;
                int exp = this.Rival.getOpponentExp()/100;
                if(this.gamePlayer.getCurrentOpponentIndex()<110)
                {
                    this.jLabelPlayerWarning.setText("You have unlocked the next rival!");
                    this.gamePlayer.unlockNextRival();
                    this.Rival = gamePlayer.getCurrentRival();
                    this.jLabelCar1Icon.setIcon(new javax.swing.ImageIcon(Rival.getOpponentCar().getCarPhotoPath()));
                    this.jLabelCarName1.setText(Rival.getOpponentCar().getCarName() + " Statistics");
                    this.jLabelSpeedSpecCar1.setText("Top Speed:   " + String.valueOf(Rival.getOpponentCar().getCarTopSpeed()));
                    this.jLabelAccSpecCar1.setText("Acceleration:  " + String.valueOf(Rival.getOpponentCar().getCarAcceleration()));
                    this.jLabelCPUOpponentName.setText(Rival.getOpponentName());
                    this.jLabelDriverXP.setText("Driver XP: " + String.valueOf(Rival.getOpponentExp()));
                }
                else
                {
                    this.jLabelPlayerWarning.setText("Congratulations! You have defeated all your rivals!");
                }
                this.jButtonNextRival.setEnabled(true);
                this.jButtonPreviousRival.setEnabled(true);
                //Getting the reward:
                this.gamePlayer.increasePlayerMoney(this.RacePrize);
                this.gamePlayer.increasePlayerExperience(exp);
                //Calculating race prize for the next rival:
                this.RacePrize = (1000*(int)Rival.getOpponentExp()/100) + 
                        (Rival.getWinTimes() - Rival.getDefeatedTimes())*50;
                if(this.RacePrize < Rival.getOpponentExp()/2)
                {
                    this.RacePrize = Rival.getOpponentExp()/2;
                }
                this.jLabelRacePrize.setText("Race Prize: " + String.valueOf(this.RacePrize)+"$");
                this.jLabelPlayerMoney.setText("Money: " + String.valueOf(gamePlayer.getPlayerMoney()) +"$");
                this.jLabelPlayerXP.setText("Player XP: " + String.valueOf(gamePlayer.getPlayerExperience()));
            }
            else
            {
                this.jLabelCPURivalLosses.setText("Losses: " + String.valueOf(Rival.getDefeatedTimes()));
                this.jLabelCPURivalWins.setText("Wins: " + String.valueOf(Rival.getWinTimes()));
                this.jLabelRacesToGo.setText("Races to go: " + String.valueOf(2-Rival.getPlayerWonTimes()));
            }
        }
    }//GEN-LAST:event_jButtonStartRaceActionPerformed
    private void CarRacing()
    {
        this.jLabelDisplayWinner.setText("Racing is in progress!");
        jLabelDisplayWinner.setForeground(new java.awt.Color(102, 102, 0));
        if (timer == null) //this will happen only once.
        {
            timer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (Drag.isRaceFinished() == false) {
                        timeCounter+=0.1;
                        jProgressBarCar1.setValue(Drag.getCar1Progress());
                        jProgressBarCar2.setValue(Drag.getCar2Progress());
                        Rival.getOpponentCar().IncreaseSpeed();
                        gamePlayer.getPlayerCar().IncreaseSpeed();
                        Drag.calculateDistanceUntilFinish(Rival, gamePlayer.getPlayerCar());
                        jLabelCar2RacingStats.setText("        " + String.valueOf(gamePlayer.getPlayerCar().getNrOfPerfectShifts()) + "                          "
                                + String.valueOf(Rival.getOpponentCar().getNrOfDrafts()) + "                       " + String.valueOf(gamePlayer.getPlayerCar().getNrOfCollision())
                                + "                   " +String.format("%7.4f", gamePlayer.getPlayerCar().getCarCurrentSpeed()) + "                  "+ String.format("%7.4f", 100 - Drag.getCar2Distance()) + 
                                "           " + String.format("%7.4f", timeCounter));
                        jLabelCar1RacingStats.setText("        " + String.valueOf(Rival.getOpponentCar().getNrOfPerfectShifts()) + "                          "
                                + String.valueOf(Rival.getOpponentCar().getNrOfDrafts()) + "                       " + String.valueOf(Rival.getOpponentCar().getNrOfCollision())
                                + "                   " +String.format("%7.4f", Rival.getOpponentCar().getCarCurrentSpeed()) + "                  " + String.format("%7.4f", 100 - Drag.getCar1Distance()) + 
                                "           " + String.format("%7.4f", timeCounter));
                        if (gamePlayer.getPlayerCar().isCollision()) {
                            gamePlayer.getPlayerCar().setCollisionFlagFalse();
                            jLabelPlayerWarning.setText("Traffic car coming towards you. Use collision controls to dodge!");
                            jLabelPlayerWarning.setForeground(new java.awt.Color(0, 0, 0));
                            jButtonCollisionControlLeft.setEnabled(true);
                            jButtonCollisionControlRight.setEnabled(true);
                            jButtonCollisionControlUp.setEnabled(true);
                            jButtonCollisionControlLeft.setForeground(new java.awt.Color(255, 255, 255));
                            jButtonCollisionControlRight.setForeground(new java.awt.Color(255, 255, 255));
                            jButtonCollisionControlUp.setForeground(new java.awt.Color(255, 255, 255));
                            timer.stop();
                            TrafficAvoider = rand.nextInt(3)+1;
                        }
                        else if(gamePlayer.getPlayerCar().isPerfectShift())
                        {
                            gamePlayer.getPlayerCar().setPerfectShiftFlagFalse();
                            jLabelPlayerWarning.setText("It's time to gear up. Use the Shift Syncronizers!");
                            jLabelPlayerWarning.setForeground(new java.awt.Color(0, 0, 0));
                            jButtonShiftSync1.setEnabled(true);
                            jButtonShiftSync2.setEnabled(true);
                            jButtonShiftSync3.setEnabled(true);
                            jButtonShiftSync1.setForeground(new java.awt.Color(255, 255, 255));
                            jButtonShiftSync2.setForeground(new java.awt.Color(255, 255, 255));
                            jButtonShiftSync3.setForeground(new java.awt.Color(255, 255, 255));
                            timer.stop();
                            TrafficAvoider = rand.nextInt(3)+1;
                        }
                    } else {
                        jProgressBarCar1.setValue(100 - (int) Drag.getCar1Distance());
                        jProgressBarCar2.setValue(100 - (int) Drag.getCar2Distance());
                        timer.stop();
                        jButtonStartRace.setText("Continue");
                        jButtonStartRace.setEnabled(true);
                        if (gamePlayer.getPlayerCar().isWinner() == true) {
                            jLabelDisplayWinner.setText(gamePlayer.getPlayerCar().getCarName() + " has won the race!");
                            jLabelDisplayWinner.setForeground(new java.awt.Color(0, 153, 0));
                            gamePlayer.increasePlayerRacesWon();
                            if(betSet)
                            {
                                gamePlayer.increasePlayerMoney(betPrize);
                                betPrize=0;
                                BetFactor=0;
                                betSet=false;
                                jButtonPlaceBet.setText("Place Bet");
                            }
                        } else if (Rival.getOpponentCar().isWinner() == true) {
                            jLabelDisplayWinner.setText(Rival.getOpponentCar().getCarName() + " has won the race!");
                            gamePlayer.increasePlayerRacesLost();
                            jLabelDisplayWinner.setForeground(new java.awt.Color(255, 0, 0));
                            if(betSet)
                            {
                                gamePlayer.decreasePlayerMoney(betPrize);
                                betPrize=0;
                                BetFactor=0;
                                betSet=false;
                                jButtonPlaceBet.setText("Place Bet");
                            }
                        } else {
                            jLabelDisplayWinner.setText("Race has ended as a draw!");
                            gamePlayer.increasePlayerRacesDrawed();
                            jLabelDisplayWinner.setForeground(new java.awt.Color(102, 102, 0));
                            if(betSet)
                            {
                                betPrize=0;
                                BetFactor=0;
                                betSet=false;
                                jButtonPlaceBet.setText("Place Bet");
                            }
                        }
                        jLabelBetPrize.setText("Bet Prize: ");
                        jLabelPlayerMoney.setText("Money: " + String.valueOf(gamePlayer.getPlayerMoney()) +"$");
                        //Save the game statistics, and the player's data:
                        SaveTheGame(PlayerSaveGame);
                    }
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();
        } else {
            timer.start();
        }
    }
    private boolean readSaveGame(File saveGameFile)
    {
            if (saveGameFile.exists()) {
            try {
                FileInputStream fi = new FileInputStream(saveGameFile);
                ObjectInputStream oi = new ObjectInputStream(fi);
                try {
                    while (true) //this loop will terminate when the catch block will terminate, and the catch block will
                    //terminate then EOFException will be thrown.
                    {
                        gamePlayer = (Player) oi.readObject(); //this will read until the file ends. 
                        //When it cannot read any more object from the file it will throw an EOFException that needs
                        //to be catched, and handled, otherwise the program will terminate.
                    }
                } catch (ClassNotFoundException e) {
                    System.out.printf("File not found: %s", e);
                } catch (EOFException b) //Once the file was done reading, it will catch this exception.
                {
                    System.out.println("Save game was successfully loaded!:\n");
                }
            } catch (FileNotFoundException e) {
                System.out.printf("Error: %s\n", e);
                return false;
            } catch (IOException e) {
                System.out.printf("Error: %s\n", e);
                return false;
            }
            if (gamePlayer == null) {
                System.out.printf("Save game was corrupted!\n");
                return false;
            } else {
                //Player stuff
                this.jLabelPlayerMoney.setText("Money: " + String.valueOf(gamePlayer.getPlayerMoney()) +"$");
                this.jLabelPlayerCarIcon.setIcon(new javax.swing.ImageIcon(gamePlayer.getPlayerCar().getCarPhotoPath()));
                this.jLabelSpeedSpecCarPlayer.setText("Top Speed:   " + String.valueOf(gamePlayer.getPlayerCar().getCarTopSpeed()));
                this.jLabelAccSpecCarPlayer.setText("Acceleration:  " + String.valueOf(gamePlayer.getPlayerCar().getCarAcceleration()));
                this.jLabelCarName2.setText(gamePlayer.getPlayerCar().getCarName() + " Statistics");
                this.jLabelPlayerXP.setText("Player XP: " + String.valueOf(gamePlayer.getPlayerExperience()));
                this.jLabelPlayer.setText(this.gamePlayer.getPlayerProfileName());
                //Player opponents stuff;
                this.Rival = gamePlayer.getCurrentRival();
                this.jLabelCar1Icon.setIcon(new javax.swing.ImageIcon(Rival.getOpponentCar().getCarPhotoPath()));
                this.jLabelCarName1.setText(Rival.getOpponentCar().getCarName() + " Statistics");
                this.jLabelSpeedSpecCar1.setText("Top Speed:   " + String.valueOf(Rival.getOpponentCar().getCarTopSpeed()));
                this.jLabelAccSpecCar1.setText("Acceleration:  " + String.valueOf(Rival.getOpponentCar().getCarAcceleration()));
                this.jLabelCPUOpponentName.setText(Rival.getOpponentName());
                this.jLabelDriverXP.setText("Driver XP: " + String.valueOf(Rival.getOpponentExp()));
                this.jLabelCPURivalLosses.setText("Losses: " + String.valueOf(Rival.getDefeatedTimes()));
                this.jLabelCPURivalWins.setText("Wins: " + String.valueOf(Rival.getWinTimes()));
                this.jLabelRacesToGo.setText("Races to go: " + String.valueOf(2-Rival.getPlayerWonTimes()));
                this.gamePlayer.getPlayerCar().Reset();
                this.Rival.getOpponentCar().Reset();
                if(gamePlayer.getCurrentOpponentIndex()==0)
                {
                    this.jButtonNextRival.setEnabled(false);
                    this.jButtonPreviousRival.setEnabled(false);
                }
                //Calculating race prize:
                this.RacePrize = (1000*(int)Rival.getOpponentExp()/100) + 
                        (Rival.getWinTimes() - Rival.getDefeatedTimes())*50;
                if(this.RacePrize < Rival.getOpponentExp()/2)
                {
                    this.RacePrize = Rival.getOpponentExp()/2;
                }
                this.jLabelRacePrize.setText("Race Prize: " + String.valueOf(this.RacePrize)+"$");
                return true;
            }
        } else {
            return false;
        }
    }
    private int SaveTheGame(File saveGameNumber) {
        try {
            FileOutputStream fo = new FileOutputStream(saveGameNumber);
            ObjectOutputStream os = new ObjectOutputStream(fo);
            //This function needs to be called before saving:
            gamePlayer.savingGameTimeAndDate();
            os.writeObject(gamePlayer);
        } catch (FileNotFoundException e) {
            System.out.printf("File Not Found Error: %s\n", e);
            return -1;
        } catch (IOException e) {
            System.out.printf("Input/Output Error: %s\n", e);
            return -1;
        }
        return 0;
    }
    private void jButtonGarageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGarageActionPerformed
       if (!this.enteredGarage) {
            this.jButtonStartRace.setVisible(false);
            //This flag needs to be set to true before calling HideGamePlayer();
            this.enteredGarage = true;
            this.HideGamePlay();
            this.jButtonCarLot.setVisible(false);
            this.jButtonGarage.setText("Back to Game!");
            this.jLabelSpeedSpecCarPlayer.setText("Player Car Top Speed:   " 
                    + String.valueOf(gamePlayer.getPlayerCar().getCarTopSpeed()) + "KMH");
            this.jLabelAccSpecCarPlayer.setText("Player Car Acceleration:  " 
                    + String.valueOf(gamePlayer.getPlayerCar().getCarAcceleration()));
            //Garage Stuff:
            this.jButtonGarageEngines.setVisible(true);
            this.jButtonGarageNitrous.setVisible(true);
            this.jButtonGarageTurbos.setVisible(true);
            this.jButtonGarageTransm.setVisible(true);
            this.jLabelGaragePlayerNitrousLevel.setVisible(true);
            this.jLabelGaragePlayerTurboLevel.setVisible(true);
            this.jLabelGaragePlayerEngineLevel.setVisible(true);
            this.jLabelGaragePlayerTransmLevel.setVisible(true);
            this.jLabelGaragePartsInfo.setVisible(true);
            this.jLabelGaragePlayerNitrousLevel.setText("Player Car Nitrous Level: " + 
                        gamePlayer.getPlayerCar().NitrousLevel);
            this.jLabelGaragePlayerEngineLevel.setText("Player Car Engine Level: " + 
                gamePlayer.getPlayerCar().EngineLevel);
            this.jLabelGaragePlayerTransmLevel.setText("Player Car Transmission Level: " + 
                gamePlayer.getPlayerCar().TransmissionLevel);
            this.jLabelGaragePlayerTurboLevel.setText("Player Car Turbo Level: " + 
                     gamePlayer.getPlayerCar().TurboLevel);
        } else {
            this.jButtonStartRace.setVisible(true);
            this.DisplayGamePlay();
            this.jButtonCarLot.setVisible(true);
            this.jButtonGarage.setText("Garage");
            this.enteredGarage = false;
            this.jLabelSpeedSpecCarPlayer.setText("Top Speed:   " + String.valueOf(gamePlayer.getPlayerCar().getCarTopSpeed()));
            this.jLabelAccSpecCarPlayer.setText("Acceleration:  " + String.valueOf(gamePlayer.getPlayerCar().getCarAcceleration()));
            //Garage Stuff
            this.jButtonGarageEngines.setVisible(false);
            this.jButtonGarageNitrous.setVisible(false);
            this.jButtonGarageTurbos.setVisible(false);
            this.jButtonGarageTransm.setVisible(false);
            this.jLabelGaragePlayerNitrousLevel.setVisible(false);
            this.jLabelGaragePlayerTurboLevel.setVisible(false);
            this.jLabelGaragePlayerEngineLevel.setVisible(false);
            this.jLabelGaragePlayerTransmLevel.setVisible(false);
            this.jLabelGaragePartsInfo.setVisible(false);
        }
    }//GEN-LAST:event_jButtonGarageActionPerformed

    private void jButtonMainMenuQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMainMenuQuitActionPerformed
        System.exit(0);
        //I will delete this later;
        //this.SaveTheGame(PlayerSaveGame);
    }//GEN-LAST:event_jButtonMainMenuQuitActionPerformed
    private void DisplayGamePlay() {
        jLabelFinish.setVisible(true);
        this.jButtonGarage.setVisible(true);
        this.jButtonStartRace.setVisible(true);
        this.jLabelFinish.setVisible(true);
        this.jLabelSpeedSpecCar1.setVisible(true);
        this.jLabelAccSpecCar1.setVisible(true);
        this.jLabelSpeedSpecCarPlayer.setVisible(true);
        this.jLabelAccSpecCarPlayer.setVisible(true);
        this.jLabelTableStatsCar2.setVisible(true);
        this.jLabelTableStatsCar1.setVisible(true);
        this.jLabelSpeedSpecCar1.setVisible(true);
        this.jLabelAccSpecCar1.setVisible(true);
        this.jLabelCar1Icon.setVisible(true);
        this.jLabelPlayerCarIcon.setVisible(true);
        this.jLabelCar2RacingStats.setVisible(true);
        this.jLabelCar1RacingStats.setVisible(true);
        this.jLabelDisplayWinner.setVisible(true);
        this.jProgressBarCar1.setVisible(true);
        this.jProgressBarCar2.setVisible(true);
        this.jLabelCarName1.setVisible(true);
        this.jLabelCarName2.setVisible(true);
        this.jButtonCarLot.setVisible(true);
        this.jLabelPlayerMoney.setVisible(true);
        this.jLabelCPUOpponentName.setVisible(true);
        this.jButtonCollisionControlLeft.setVisible(true);
        this.jButtonCollisionControlRight.setVisible(true);
        this.jButtonCollisionControlUp.setVisible(true);
        this.jButtonShiftSync1.setVisible(true);
        this.jButtonShiftSync2.setVisible(true);
        this.jButtonShiftSync3.setVisible(true);
        this.jLabelShiftSyncronizerTab.setVisible(true);
        this.jLabelCollisionControlTab.setVisible(true);
        this.jLabelPlayerWarning.setVisible(true);
        this.jLabelPlayer.setVisible(true);
        this.jButtonPlayerStats.setVisible(true);
        this.jButtonSafeHouse.setVisible(true);
        this.jLabelDriverXP.setVisible(true);
        this.jLabelPlayerXP.setVisible(true);
        this.jLabelRacesToGo.setVisible(true);
        this.jButtonNextRival.setVisible(true);
        this.jButtonPreviousRival.setVisible(true);
        this.jLabelCPURivalLosses.setVisible(true);
        this.jLabelCPURivalWins.setVisible(true);
        this.jButtonPlaceBet.setVisible(true);
        this.jLabelRacePrize.setVisible(true);
        this.jLabelBetPrize.setVisible(true);
        this.jButtonMainMenuNewGame.setEnabled(true);
        //Hiding the menu buttons:
        if(!enteredGamePlay && !enteredGarage && !enteredCarLot && !enteredSafeHouse && !enteredPlayerStats
                && !enteredPlaceBet)
        {
            this.jButtonMainMenuNewGame.setText("MAIN MENU");
            this.jButtonMainMenuLoadGame.setVisible(false);
            this.jButtonMainMenuInfo.setVisible(false);
            this.jLabelDragRacingLogo.setVisible(false);
        }
    }
    private void HideGamePlay()
    {
        if(!enteredGarage)
        {
            this.jButtonGarage.setVisible(false);
        }
        this.jButtonStartRace.setVisible(false);
        this.jLabelFinish.setVisible(false);
        this.jLabelSpeedSpecCar1.setVisible(false);
        this.jLabelAccSpecCar1.setVisible(false);
        this.jLabelSpeedSpecCarPlayer.setVisible(false);
        this.jLabelAccSpecCarPlayer.setVisible(false);
        this.jLabelTableStatsCar2.setVisible(false);
        this.jLabelTableStatsCar1.setVisible(false);
        this.jLabelSpeedSpecCar1.setVisible(false);
        this.jLabelAccSpecCar1.setVisible(false);
        this.jLabelCar1Icon.setVisible(false);
        this.jLabelPlayerCarIcon.setVisible(false);
        this.jLabelCar2RacingStats.setVisible(false);
        this.jLabelCar1RacingStats.setVisible(false);
        this.jLabelDisplayWinner.setVisible(false);
        this.jProgressBarCar1.setVisible(false);
        this.jProgressBarCar2.setVisible(false);
        this.jLabelCarName1.setVisible(false);
        this.jLabelCarName2.setVisible(false);
        this.jButtonCarLotNext.setVisible(false);
        this.jButtonCarLotPrevious.setVisible(false);
        this.jLabelCarLotSpecs.setVisible(false);
        this.jLabelCarLotContent.setVisible(false);
        this.jLabelCPUOpponentName.setVisible(false);
        this.jLabelPlayer.setVisible(false);
        this.jButtonCollisionControlLeft.setVisible(false);
        this.jButtonCollisionControlRight.setVisible(false);
        this.jButtonCollisionControlUp.setVisible(false);
        this.jButtonShiftSync1.setVisible(false);
        this.jButtonShiftSync2.setVisible(false);
        this.jButtonShiftSync3.setVisible(false);
        this.jButtonPlaceBet.setVisible(false);
        this.jLabelRacePrize.setVisible(false);
        this.jLabelBetPrize.setVisible(false);
        if(!enteredSafeHouse)
        {
            if(!enteredPlayerStats)
            {
                this.jLabelShiftSyncronizerTab.setVisible(false);
            }
            this.jLabelCollisionControlTab.setVisible(false);
            this.jLabelPlayerWarning.setVisible(false);
            this.jButtonSafeHouse.setVisible(false);
            this.jLabelRacesToGo.setVisible(false);
        }
        if(!enteredPlayerStats && !enteredSafeHouse)
        {
            this.jButtonPlayerStats.setVisible(false);
        }
        if(!enteredCarLot)
        {
            this.jButtonCarLot.setVisible(false);
        }
        this.jLabelDriverXP.setVisible(false);
        this.jLabelPlayerXP.setVisible(false);
        this.jButtonNextRival.setVisible(false);
        this.jButtonPreviousRival.setVisible(false);
        this.jLabelCPURivalLosses.setVisible(false);
        this.jLabelCPURivalWins.setVisible(false);
        if(enteredCarLot || enteredSafeHouse || enteredPlayerStats || enteredPlaceBet || enteredGarage)
        {
           this.jButtonMainMenuNewGame.setEnabled(false);
        }
    }
    private void jButtonMainMenuNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMainMenuNewGameActionPerformed
        if(!enteredGamePlay && !gamePlayRunning)
        {
            this.enteredGamePlay = true;
            this.jButtonCarLotActionPerformed(evt);
            this.jButtonMainMenuLoadGame.setVisible(false);
            this.jButtonMainMenuNewGame.setVisible(false);
            this.jLabelDragRacingLogo.setVisible(false);
            this.jButtonMainMenuInfo.setVisible(false);
            this.jLabelPlayerMoney.setVisible(true);
            gamePlayer = new Player();
            this.jLabelPlayerMoney.setText("Money: " + String.valueOf(gamePlayer.getPlayerMoney()) +"$");
            this.jButtonCarLot.setEnabled(false);
        }
        else if(enteredGamePlay)
        {
            this.HideGamePlay();
            this.jButtonMainMenuNewGame.setText("RESUME");
            this.jLabelDragRacingLogo.setVisible(true);
            this.jLabelPlayerMoney.setVisible(false);
            this.jButtonMainMenuInfo.setVisible(true);
            this.jButtonMainMenuLoadGame.setVisible(true);
            this.enteredGamePlay = false;
        }
        else
        {
            this.DisplayGamePlay();
            this.jButtonMainMenuNewGame.setText("MAIN MENU");
            this.jLabelPlayerMoney.setVisible(true);
            this.jButtonMainMenuInfo.setVisible(false);
            this.jButtonMainMenuLoadGame.setVisible(false);
            this.jLabelDragRacingLogo.setVisible(false);
            this.enteredGamePlay = true;
        }
    }//GEN-LAST:event_jButtonMainMenuNewGameActionPerformed

    private void jButtonCarLotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCarLotActionPerformed
        if (!this.enteredCarLot && !enteredPlaceBet) {
            this.enteredCarLot = true;
            //This function has to be called after the flag is set to true.
            this.HideGamePlay();
            //CarLot Stuff:
            this.jButtonCarLotBuy.setVisible(true);
            this.jButtonCarLotNext.setVisible(true);
            this.jButtonCarLotPrevious.setVisible(true);
            this.jLabelCarLotSpecs.setVisible(true);
            this.jLabelCarLotContent.setVisible(true);
            this.jButtonCarLot.setVisible(true);
            this.jLabelCarLotName.setVisible(true);
            this.jLabelCarLotPrice.setVisible(true);
            this.jButtonCarLot.setText("Back to Game!");
            this.jLabelCarLotName.setText(this.AllCars.get(this.carLotIndex).getCarName());
            this.jLabelCarLotPrice.setText("Price: " + String.valueOf(this.AllCars.get(this.carLotIndex).getCarPrice()) + "$");
            this.jLabelCarLotSpecs.setText("Speed: " + String.valueOf(this.AllCars.get(this.carLotIndex).getCarTopSpeed())
                    + "KMH      Acceleration: " + String.valueOf(this.AllCars.get(this.carLotIndex).getCarAcceleration()));
            this.jLabelCarLotContent.setIcon(new javax.swing.ImageIcon(this.AllCars.get(this.carLotIndex).getCarPhotoPath()));
        }
        else if(enteredPlaceBet)
        {
            if(this.gamePlayer.getPlayerMoney()>=this.BetFactor)
            {
                this.betPrize=this.BetFactor;
                this.jLabelBetPrize.setText("Bet Prize: " + String.valueOf(this.betPrize) + "$");
                this.betSet = true;
                this.jLabelPlayerWarning.setText("");
                this.jLabelPlayerMoney.setForeground(new java.awt.Color(0, 0, 0));
            }
            else
            {
                this.jLabelPlayerWarning.setText("You don't have enough money!");
                this.jLabelPlayerMoney.setForeground(new java.awt.Color(255, 0, 0));
            }
        }
        else {
            this.DisplayGamePlay();
            //CarLot Stuff:
            this.jButtonCarLotNext.setVisible(false);
            this.jButtonCarLotPrevious.setVisible(false);
            this.jLabelCarLotSpecs.setVisible(false);
            this.jLabelCarLotContent.setVisible(false);
            this.enteredCarLot = false;
            this.jButtonCarLot.setText("Car Lot");
            this.jLabelCarLotName.setVisible(false);
            this.jLabelCarLotPrice.setVisible(false);
            this.jButtonCarLotBuy.setVisible(false);
            //this are being used only when creating a new game.
            this.jLabelShiftSyncronizerTab.setForeground(new java.awt.Color(0, 0, 255));
            this.jLabelShiftSyncronizerTab.setText("Shift Syncronizer:");
            this.jTextFieldProfileName.setVisible(false);
            this.jButtonMainMenuNewGame.setVisible(true);
            this.jButtonMainMenuNewGame.setText("MAIN MENU");
        }
    }//GEN-LAST:event_jButtonCarLotActionPerformed

    private void jButtonCarLotNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCarLotNextActionPerformed
        if(enteredCarLot)
        {
            carLotIndex++;
            this.jLabelCarLotContent.setIcon(new javax.swing.ImageIcon(this.AllCars.get(carLotIndex).getCarPhotoPath()));
            this.jLabelCarLotName.setText(this.AllCars.get(this.carLotIndex).getCarName());
            this.jLabelCarLotPrice.setText("Price: " + String.valueOf(this.AllCars.get(this.carLotIndex).getCarPrice()) + "$");
            this.jLabelCarLotSpecs.setText("Speed: " + String.valueOf(this.AllCars.get(this.carLotIndex).getCarTopSpeed())
                    + "KMH      Acceleration: " + String.valueOf(this.AllCars.get(this.carLotIndex).getCarAcceleration()));
            if (carLotIndex == AllCars.size() - 1) {
                carLotIndex = 0;
            }
        }
        else
        {
            if(safehousePlayerCarIndex+1<gamePlayer.getPlayerNumberOfCars())
            {
                safehousePlayerCarIndex++;
            }
            else
            {
                safehousePlayerCarIndex = 0;
            }
            this.jLabelCarLotContent.setIcon(new javax.swing.ImageIcon(this.gamePlayer.getPlayerCarFromList(this.safehousePlayerCarIndex).getCarPhotoPath()));
            this.jLabelCarLotName.setText(this.gamePlayer.getPlayerCarFromList(this.safehousePlayerCarIndex).getCarName());
            this.jLabelCarLotSpecs.setText("Speed: " + String.valueOf(this.gamePlayer.getPlayerCarFromList(this.safehousePlayerCarIndex).getCarTopSpeed())
                    + "KMH      Acceleration: " + String.valueOf(this.gamePlayer.getPlayerCarFromList(this.safehousePlayerCarIndex).getCarAcceleration()));
        }

    }//GEN-LAST:event_jButtonCarLotNextActionPerformed

    private void jButtonCarLotPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCarLotPreviousActionPerformed
        if(enteredCarLot)
        {
            if (carLotIndex <= 0) {
                carLotIndex = (AllCars.size() - 1);
            }
            else
            {
                carLotIndex--;
            }
            this.jLabelCarLotContent.setIcon(new javax.swing.ImageIcon(this.AllCars.get(carLotIndex).getCarPhotoPath()));
            this.jLabelCarLotName.setText(this.AllCars.get(this.carLotIndex).getCarName());
            this.jLabelCarLotPrice.setText("Price: " + String.valueOf(this.AllCars.get(this.carLotIndex).getCarPrice()) + "$");
            this.jLabelCarLotSpecs.setText("Speed: " + String.valueOf(this.AllCars.get(this.carLotIndex).getCarTopSpeed())
                    + "KMH      Acceleration: " + String.valueOf(this.AllCars.get(this.carLotIndex).getCarAcceleration()));
        }
        else
        {
            if (safehousePlayerCarIndex <= 0) {
                safehousePlayerCarIndex = (gamePlayer.getPlayerNumberOfCars() - 1);
            }
            else
            {
                safehousePlayerCarIndex--;
            }
            this.jLabelCarLotContent.setIcon(new javax.swing.ImageIcon(this.gamePlayer.getPlayerCarFromList(this.safehousePlayerCarIndex).getCarPhotoPath()));
            this.jLabelCarLotName.setText(this.gamePlayer.getPlayerCarFromList(this.safehousePlayerCarIndex).getCarName());
            this.jLabelCarLotSpecs.setText("Speed: " + String.valueOf(this.gamePlayer.getPlayerCarFromList(this.safehousePlayerCarIndex).getCarTopSpeed())
                    + "KMH      Acceleration: " + String.valueOf(this.gamePlayer.getPlayerCarFromList(this.safehousePlayerCarIndex).getCarAcceleration()));
        }
    }//GEN-LAST:event_jButtonCarLotPreviousActionPerformed

    private void jButtonMainMenuLoadGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMainMenuLoadGameActionPerformed
        if(enteredMenuLoadGame ==false)
        {
            this.enteredMenuLoadGame = true;
            this.jButtonLoadSaveGameNum1.setVisible(true);
            this.jButtonLoadSaveGameNum2.setVisible(true);
            this.jButtonLoadSaveGameNum3.setVisible(true);
            this.jButtonMainMenuNewGame.setVisible(false);
            this.jButtonMainMenuInfo.setVisible(false);
            this.jButtonMainMenuLoadGame.setText("BACK");
            if(this.readSaveGame(PlayerSaveGame)==true)
            {
                this.jButtonLoadSaveGameNum1.setEnabled(true);
                this.jButtonLoadSaveGameNum1.setText("SaveGame 1 From: " + gamePlayer.getSavingTimeAndDate());
            }
            else
            {
                this.jButtonLoadSaveGameNum1.setEnabled(false);
                this.jButtonLoadSaveGameNum1.setText("SaveGame 1 Not Present");
            }
            if(this.readSaveGame(PlayerSaveGame2)==true)
            {
                this.jButtonLoadSaveGameNum2.setEnabled(true);
                this.jButtonLoadSaveGameNum2.setText("SaveGame 2 From: " + gamePlayer.getSavingTimeAndDate());
            }
            else
            {
                this.jButtonLoadSaveGameNum2.setEnabled(false);
                this.jButtonLoadSaveGameNum2.setText("SaveGame 2 Not Present");
            }
            if(this.readSaveGame(PlayerSaveGame3)==true)
            {
                this.jButtonLoadSaveGameNum3.setEnabled(true);
                this.jButtonLoadSaveGameNum3.setText("SaveGame 3 From: " + gamePlayer.getSavingTimeAndDate());
            }
            else
            {
                this.jButtonLoadSaveGameNum3.setEnabled(false);
                this.jButtonLoadSaveGameNum3.setText("SaveGame 3 Not Present");
            }
        }
        else
        {
            this.enteredMenuLoadGame = false;
            this.jButtonLoadSaveGameNum1.setVisible(false);
            this.jButtonLoadSaveGameNum2.setVisible(false);
            this.jButtonLoadSaveGameNum3.setVisible(false);
            this.jButtonMainMenuLoadGame.setText("LOAD GAME");
            this.jButtonMainMenuNewGame.setVisible(true);
            this.jButtonMainMenuInfo.setVisible(true);
        }
    }//GEN-LAST:event_jButtonMainMenuLoadGameActionPerformed

    private void jButtonCarLotBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCarLotBuyActionPerformed
        if(enteredCarLot)
        {
            if (gamePlayer.getPlayerMoney() >= this.AllCars.get(this.carLotIndex).getCarPrice()) 
            {
                gamePlayer.decreasePlayerMoney(this.AllCars.get(this.carLotIndex).getCarPrice());
                gamePlayer.changePlayerCar(this.AllCars.get(this.carLotIndex));
                this.jLabelShiftSyncronizerTab.setVisible(true);
                this.jLabelShiftSyncronizerTab.setForeground(new java.awt.Color(0, 0, 0));
                this.jLabelShiftSyncronizerTab.setText("Enter your name: ");
                this.jTextFieldProfileName.setVisible(true);
                this.jLabelPlayerMoney.setText("Money: " + String.valueOf(gamePlayer.getPlayerMoney()) +"$");
                jLabelPlayerCarIcon.setIcon(new javax.swing.ImageIcon(gamePlayer.getPlayerCar().getCarPhotoPath()));
                jLabelSpeedSpecCarPlayer.setText("Top Speed:   " + String.valueOf(gamePlayer.getPlayerCar().getCarTopSpeed()));
                jLabelAccSpecCarPlayer.setText("Acceleration:  " + String.valueOf(gamePlayer.getPlayerCar().getCarAcceleration()));
                this.jLabelCarName2.setText(gamePlayer.getPlayerCar().getCarName() + " Statistics");
                this.jLabelPlayerXP.setText("Player XP: " + String.valueOf(gamePlayer.getPlayerExperience()));
                //First opponents:
                this.Rival = gamePlayer.getCurrentRival();
                this.jLabelCar1Icon.setIcon(new javax.swing.ImageIcon(Rival.getOpponentCar().getCarPhotoPath()));
                this.jLabelCarName1.setText(Rival.getOpponentCar().getCarName() + " Statistics");
                this.jLabelSpeedSpecCar1.setText("Top Speed:   " + String.valueOf(Rival.getOpponentCar().getCarTopSpeed()));
                this.jLabelAccSpecCar1.setText("Acceleration:  " + String.valueOf(Rival.getOpponentCar().getCarAcceleration()));
                this.jLabelCPUOpponentName.setText(Rival.getOpponentName());
                this.jLabelDriverXP.setText("Driver XP: " + String.valueOf(Rival.getOpponentExp()));
                this.jButtonNextRival.setEnabled(false);
                this.jButtonPreviousRival.setEnabled(false);
                this.jLabelCPURivalLosses.setText("Losses: " + String.valueOf(Rival.getDefeatedTimes()));
                this.jLabelCPURivalWins.setText("Wins: " + String.valueOf(Rival.getWinTimes()));
                this.jLabelRacesToGo.setText("Races to go: " + String.valueOf(2-Rival.getPlayerWonTimes()));
                //Calculating race prize:
                this.RacePrize = (1000*(int)Rival.getOpponentExp()/100) + 
                        (Rival.getWinTimes() - Rival.getDefeatedTimes())*50;
                if(this.RacePrize < Rival.getOpponentExp()/2)
                {
                    this.RacePrize = Rival.getOpponentExp()/2;
                }
                this.jLabelRacePrize.setText("Race Prize: " + String.valueOf(this.RacePrize)+"$");
                this.gamePlayRunning = true;
                //I will delete this later:
                this.SaveTheGame(PlayerSaveGame);
            }
            else
            {
                this.jLabelPlayerWarning.setText("You don't have enough money!");
                this.jLabelPlayerMoney.setForeground(new java.awt.Color(255, 0, 0));
            }
        }
        else
        {
            gamePlayer.changePlayerCar(this.gamePlayer.getPlayerCarFromList(this.safehousePlayerCarIndex));
            jLabelPlayerCarIcon.setIcon(new javax.swing.ImageIcon(gamePlayer.getPlayerCar().getCarPhotoPath()));
            jLabelSpeedSpecCarPlayer.setText("Top Speed:   " + String.valueOf(gamePlayer.getPlayerCar().getCarTopSpeed()));
            jLabelAccSpecCarPlayer.setText("Acceleration:  " + String.valueOf(gamePlayer.getPlayerCar().getCarAcceleration()));
            this.jLabelCarName2.setText(gamePlayer.getPlayerCar().getCarName() + " Statistics");
            this.jLabelShiftSyncronizerTab.setText("Player Current Car: " + gamePlayer.getPlayerCar().getCarName());
            this.jLabelPlayerWarning.setText("");
            this.jLabelPlayerMoney.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_jButtonCarLotBuyActionPerformed

    private void jButtonCollisionControlLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCollisionControlLeftActionPerformed
        timer.start();
        if(TrafficAvoider!=1)
        {
            gamePlayer.getPlayerCar().increaseNrOfColision();
            gamePlayer.increasePlayerCollision();
            gamePlayer.getPlayerCar().dicreaseCarCurrentSpeed();
            gamePlayer.getPlayerCar().dicreaseCarAcceleration();
            jLabelPlayerWarning.setText("You failed to avoid the traffic car!");
            jLabelPlayerWarning.setForeground(new java.awt.Color(255, 0, 0));
            TrafficAvoider=0;
        }
        else
        {
            jLabelPlayerWarning.setText("You have dodged successfully!");
            jLabelPlayerWarning.setForeground(new java.awt.Color(0, 153, 0));
        }
        this.jButtonCollisionControlLeft.setEnabled(false);
        this.jButtonCollisionControlRight.setEnabled(false);
        this.jButtonCollisionControlUp.setEnabled(false);
        this.jButtonCollisionControlLeft.setForeground(new java.awt.Color(0, 0, 0));
        this.jButtonCollisionControlRight.setForeground(new java.awt.Color(0, 0, 0));
        this.jButtonCollisionControlUp.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jButtonCollisionControlLeftActionPerformed

    private void jButtonCollisionControlRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCollisionControlRightActionPerformed
        timer.start();
        if(TrafficAvoider!=2)
        {
            gamePlayer.getPlayerCar().increaseNrOfColision();
            gamePlayer.increasePlayerCollision();
            gamePlayer.getPlayerCar().dicreaseCarCurrentSpeed();
            gamePlayer.getPlayerCar().dicreaseCarAcceleration();
            jLabelPlayerWarning.setText("You failed to avoid the traffic car!");
            jLabelPlayerWarning.setForeground(new java.awt.Color(255, 0, 0));
            TrafficAvoider=0;
        }
        else
        {
            jLabelPlayerWarning.setText("You have dodged successfully!");
            jLabelPlayerWarning.setForeground(new java.awt.Color(0, 153, 0));
        }
        this.jButtonCollisionControlLeft.setEnabled(false);
        this.jButtonCollisionControlRight.setEnabled(false);
        this.jButtonCollisionControlUp.setEnabled(false);
        this.jButtonCollisionControlLeft.setForeground(new java.awt.Color(0, 0, 0));
        this.jButtonCollisionControlRight.setForeground(new java.awt.Color(0, 0, 0));
        this.jButtonCollisionControlUp.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jButtonCollisionControlRightActionPerformed

    private void jButtonCollisionControlUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCollisionControlUpActionPerformed
        timer.start();
        if(TrafficAvoider!=3)
        {
            gamePlayer.getPlayerCar().increaseNrOfColision();
            gamePlayer.increasePlayerCollision();
            gamePlayer.getPlayerCar().dicreaseCarCurrentSpeed();
            gamePlayer.getPlayerCar().dicreaseCarAcceleration();
            jLabelPlayerWarning.setText("You failed to avoid the traffic car!");
            jLabelPlayerWarning.setForeground(new java.awt.Color(255, 0, 0));
            TrafficAvoider=0;
        }
        else
        {
            jLabelPlayerWarning.setText("You have dodged successfully!");
            jLabelPlayerWarning.setForeground(new java.awt.Color(0, 153, 0));
        }
        this.jButtonCollisionControlLeft.setEnabled(false);
        this.jButtonCollisionControlRight.setEnabled(false);
        this.jButtonCollisionControlUp.setEnabled(false);
        this.jButtonCollisionControlLeft.setForeground(new java.awt.Color(0, 0, 0));
        this.jButtonCollisionControlRight.setForeground(new java.awt.Color(0, 0, 0));
        this.jButtonCollisionControlUp.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jButtonCollisionControlUpActionPerformed

    private void jButtonShiftSync1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShiftSync1ActionPerformed
        timer.start();
        if(TrafficAvoider==1)
        {
            gamePlayer.getPlayerCar().increaseNrOfPerfectShifts();
            gamePlayer.increasePlayerPerfectShifts();
            gamePlayer.getPlayerCar().increaseCurrentSpeed();
            gamePlayer.getPlayerCar().increaseAcceleration();
            jLabelPlayerWarning.setText("You have shifted perfectly!");
            jLabelPlayerWarning.setForeground(new java.awt.Color(0, 153, 0));
            TrafficAvoider=0;
        }
        else
        {
            jLabelPlayerWarning.setText("You didn't shifted right!");
            jLabelPlayerWarning.setForeground(new java.awt.Color(255, 0, 0));
        }
        this.jButtonShiftSync1.setEnabled(false);
        this.jButtonShiftSync2.setEnabled(false);
        this.jButtonShiftSync3.setEnabled(false);
        this.jButtonShiftSync1.setForeground(new java.awt.Color(0, 0, 0));
        this.jButtonShiftSync2.setForeground(new java.awt.Color(0, 0, 0));
        this.jButtonShiftSync3.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jButtonShiftSync1ActionPerformed

    private void jButtonShiftSync2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShiftSync2ActionPerformed
        timer.start();
        if(TrafficAvoider==2)
        {
            gamePlayer.getPlayerCar().increaseNrOfPerfectShifts();
            gamePlayer.increasePlayerPerfectShifts();
            gamePlayer.getPlayerCar().increaseCurrentSpeed();
            gamePlayer.getPlayerCar().increaseAcceleration();
            jLabelPlayerWarning.setText("You have shifted perfectly!");
            jLabelPlayerWarning.setForeground(new java.awt.Color(0, 153, 0));
            TrafficAvoider=0;
        }
        else
        {
            jLabelPlayerWarning.setText("You didn't shifted right!");
            jLabelPlayerWarning.setForeground(new java.awt.Color(255, 0, 0));
        }
        this.jButtonShiftSync1.setEnabled(false);
        this.jButtonShiftSync2.setEnabled(false);
        this.jButtonShiftSync3.setEnabled(false);
        this.jButtonShiftSync1.setForeground(new java.awt.Color(0, 0, 0));
        this.jButtonShiftSync2.setForeground(new java.awt.Color(0, 0, 0));
        this.jButtonShiftSync3.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jButtonShiftSync2ActionPerformed

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden

    }//GEN-LAST:event_formComponentHidden

    private void jButtonShiftSync3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShiftSync3ActionPerformed
                timer.start();
        if(TrafficAvoider==3)
        {
            gamePlayer.getPlayerCar().increaseNrOfPerfectShifts();
            gamePlayer.increasePlayerPerfectShifts();
            gamePlayer.getPlayerCar().increaseCurrentSpeed();
            gamePlayer.getPlayerCar().increaseAcceleration();
            jLabelPlayerWarning.setText("You have shifted perfectly!");
            jLabelPlayerWarning.setForeground(new java.awt.Color(0, 153, 0));
            TrafficAvoider=0;
        }
        else
        {
            jLabelPlayerWarning.setText("You didn't shifted right!");
            jLabelPlayerWarning.setForeground(new java.awt.Color(255, 0, 0));
        }
        this.jButtonShiftSync1.setEnabled(false);
        this.jButtonShiftSync2.setEnabled(false);
        this.jButtonShiftSync3.setEnabled(false);
        this.jButtonShiftSync1.setForeground(new java.awt.Color(0, 0, 0));
        this.jButtonShiftSync2.setForeground(new java.awt.Color(0, 0, 0));
        this.jButtonShiftSync3.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jButtonShiftSync3ActionPerformed

    private void jButtonPlayerStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlayerStatsActionPerformed
        if (!this.enteredPlayerStats && !enteredSafeHouse && !enteredPlaceBet) {
            //This flag needs to be set to true before calling HideGamePlayer();
            this.enteredPlayerStats = true;
            this.HideGamePlay();
            //PlayerStats Stuff:
            float completion = (((float)this.gamePlayer.getCurrentOpponentIndex()+1)/110)*100;
            this.jLabelShiftSyncronizerTab.setForeground(new java.awt.Color(0, 0, 0));
            this.jLabelShiftSyncronizerTab.setText("Completion: " + String.valueOf(completion)+ "%");
            this.jButtonPlayerStats.setText("Back to Game!");
            this.jLabelPlayerStatsCollisions.setVisible(true);
            this.jLabelPlayerStatsRacesWon.setVisible(true);
            this.jLabelPlayerStatsRacesLost.setVisible(true);
            this.jLabelPlayerStatsRacesDrawed.setVisible(true);
            this.jLabelPlayerStatsPerfectShifts.setVisible(true);
            this.jLabelPlayerStatsCollisions.setText("Player Collisions: " + String.valueOf(gamePlayer.getPlayerCollisions()));
            this.jLabelPlayerStatsRacesWon.setText("Player Races Won: " + String.valueOf(gamePlayer.getPlayerRacesWon()));
            this.jLabelPlayerStatsRacesLost.setText("Player Races Lost: " + String.valueOf(gamePlayer.getPlayerRacesLost()));
            this.jLabelPlayerStatsRacesDrawed.setText("Player Races Drawed: " + String.valueOf(gamePlayer.getPlayerRacesDrawed()));
            this.jLabelPlayerStatsPerfectShifts.setText("Player Perfect Shifts: " + String.valueOf(gamePlayer.getPlayerPerfectShifts()));
                                                    
        } 
        else if(enteredPlayerStats){
            this.DisplayGamePlay();
            //PlayerStats Stuff:
            this.enteredPlayerStats = false;
            this.jLabelShiftSyncronizerTab.setText("Shift Syncronizer:");
            this.jLabelShiftSyncronizerTab.setForeground(new java.awt.Color(0, 0, 255));
            this.jButtonPlayerStats.setText("Player Stats");
            this.jLabelPlayerStatsCollisions.setVisible(false);
            this.jLabelPlayerStatsRacesWon.setVisible(false);
            this.jLabelPlayerStatsRacesLost.setVisible(false);
            this.jLabelPlayerStatsRacesDrawed.setVisible(false);
            this.jLabelPlayerStatsPerfectShifts.setVisible(false);
        }
        else if(enteredSafeHouse)
        {
            this.jLabelPlayerWarning.setText("Please select a slot: ");
            this.jButtonLoadSaveGameNum1.setVisible(true);
            this.jButtonLoadSaveGameNum2.setVisible(true);
            this.jButtonLoadSaveGameNum3.setVisible(true);
            this.jButtonLoadSaveGameNum1.setEnabled(true);
            this.jButtonLoadSaveGameNum2.setEnabled(true);
            this.jButtonLoadSaveGameNum3.setEnabled(true);
            this.jButtonLoadSaveGameNum1.setText("Save Slot 1");
            this.jButtonLoadSaveGameNum2.setText("Save Slot 2");
            this.jButtonLoadSaveGameNum3.setText("Save Slot 3");
        }
        else if(enteredPlaceBet)
        {
            if(this.gamePlayer.getPlayerMoney()>=this.BetFactor/4)
            {
                this.betPrize = this.BetFactor/4;
                this.jLabelBetPrize.setText("Bet Prize: " + String.valueOf(this.betPrize) + "$");
                this.betSet = true;
                this.jLabelPlayerWarning.setText("");
                this.jLabelPlayerMoney.setForeground(new java.awt.Color(0, 0, 0));
            }
            else
            {
                this.jLabelPlayerWarning.setText("You don't have enough money!");
                this.jLabelPlayerMoney.setForeground(new java.awt.Color(255, 0, 0));
            }
        }
    }//GEN-LAST:event_jButtonPlayerStatsActionPerformed

    private void jButtonGarageEnginesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGarageEnginesActionPerformed
        if(!enteredGarageEngines && !enteredGarageTurbos && !enteredGarageTransmissions 
                && !enteredGarageNitrous)
        {
            this.enteredGarageEngines=true;
            this.jButtonGarageEngines.setText("Back to parts menu!");
            this.jButtonGarageNitrous.setText("Engine Level 3 - " + 
                    gameGarage.getEngineLevel3Price() + "$");
            this.jButtonGarageTransm.setText("Engine Level 2 - " + 
                     gameGarage.getEngineLevel2Price() + "$");
            this.jButtonGarageTurbos.setText("Engine Level 1 - " + 
                    gameGarage.getEngineLevel1Price() + "$");
        }
        else
        {
            this.enteredGarageEngines=false;
            this.enteredGarageTurbos=false;
            this.enteredGarageTransmissions=false;
            this.enteredGarageNitrous=false;        
            this.jButtonGarageEngines.setText("Engine Packs");
            this.jButtonGarageNitrous.setText("Nitrous Packs");
            this.jButtonGarageTransm.setText("Transmission Packs");
            this.jButtonGarageTurbos.setText("Turbo Packs");
            this.jLabelPlayerMoney.setForeground(new java.awt.Color(0, 0, 0));
            this.jLabelGaragePlayerEngineLevel.setForeground(new java.awt.Color(0, 0, 0));
            this.jLabelGaragePlayerNitrousLevel.setForeground(new java.awt.Color(0, 0, 0));
            this.jLabelGaragePlayerTransmLevel.setForeground(new java.awt.Color(0, 0, 0));
            this.jLabelGaragePlayerTurboLevel.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_jButtonGarageEnginesActionPerformed
    private void RepaintGaragePlayerCharacteristics()
    {
        this.jLabelPlayerMoney.setForeground(new java.awt.Color(0, 0, 0));
        this.jLabelGaragePlayerEngineLevel.setForeground(new java.awt.Color(0, 0, 0));
        this.jLabelGaragePlayerNitrousLevel.setForeground(new java.awt.Color(0, 0, 0));
        this.jLabelGaragePlayerTransmLevel.setForeground(new java.awt.Color(0, 0, 0));
        this.jLabelGaragePlayerTurboLevel.setForeground(new java.awt.Color(0, 0, 0));
        this.jLabelGaragePlayerNitrousLevel.setText("Player Car Nitrous Level: " + 
                gamePlayer.getPlayerCar().NitrousLevel);
        this.jLabelGaragePlayerEngineLevel.setText("Player Car Engine Level: " + 
            gamePlayer.getPlayerCar().EngineLevel);
        this.jLabelGaragePlayerTransmLevel.setText("Player Car Transmission Level: " + 
            gamePlayer.getPlayerCar().TransmissionLevel);
        this.jLabelGaragePlayerTurboLevel.setText("Player Car Turbo Level: " + 
                 gamePlayer.getPlayerCar().TurboLevel);
        this.jLabelSpeedSpecCarPlayer.setText("Player Car Top Speed:   " 
                + String.valueOf(gamePlayer.getPlayerCar().getCarTopSpeed()) + "KMH");
        this.jLabelAccSpecCarPlayer.setText("Player Car Acceleration:  " 
                + String.valueOf(gamePlayer.getPlayerCar().getCarAcceleration()));
        this.jLabelPlayerMoney.setText("Money: " + String.valueOf(gamePlayer.getPlayerMoney()) +"$");
    }
    private void jButtonGarageTurbosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGarageTurbosActionPerformed
        if(!enteredGarageEngines && !enteredGarageTurbos && !enteredGarageTransmissions 
                && !enteredGarageNitrous)
        {
            this.enteredGarageTurbos=true;
            this.jButtonGarageEngines.setText("Back to parts menu!");
            this.jButtonGarageNitrous.setText("Turbo Level 3 - " + 
                    gameGarage.getTurboLevel3Price() + "$");
            this.jButtonGarageTransm.setText("Turbo Level 2 - " + 
                     gameGarage.getTurboLevel2Price() + "$");
            this.jButtonGarageTurbos.setText("Turbo Level 1 - " + 
                    gameGarage.getTurboLevel1Price() + "$");
        }
        else if(enteredGarageEngines)
        {
            int i = gameGarage.buyLevel1Engine(gamePlayer);
            if(i==1)
            {
               this.jLabelPlayerMoney.setForeground(new java.awt.Color(255, 0, 0));
            }
            else if(i==2)
            {
                this.jLabelGaragePlayerEngineLevel.setForeground(new java.awt.Color(255, 0, 0));
            }
            else
            {
                //Repaint Car Statistics and money:
                this.RepaintGaragePlayerCharacteristics();
            }
        }
        else if(enteredGarageTransmissions)
        {
            int i = gameGarage.buyLevel1Transmission(gamePlayer);
            if(i==1)
            {
               this.jLabelPlayerMoney.setForeground(new java.awt.Color(255, 0, 0));
            }
            else if(i==2)
            {
                this.jLabelGaragePlayerTransmLevel.setForeground(new java.awt.Color(255, 0, 0));
            }
            else
            {
                //Repaint Car Statistics and money:
                this.RepaintGaragePlayerCharacteristics();
            }
        }
        else if(enteredGarageNitrous)
        {
            int i = gameGarage.buyLevel1Turbo(gamePlayer);
            if(i==1)
            {
               this.jLabelPlayerMoney.setForeground(new java.awt.Color(255, 0, 0));
            }
            else if(i==2)
            {
                this.jLabelGaragePlayerNitrousLevel.setForeground(new java.awt.Color(255, 0, 0));
            }
            else
            {
                //Repaint Car Statistics and money:
                this.RepaintGaragePlayerCharacteristics();
            }
        }
        else if(enteredGarageTurbos)
        {
            int i = gameGarage.buyLevel1Turbo(gamePlayer);
            if(i==1)
            {
               this.jLabelPlayerMoney.setForeground(new java.awt.Color(255, 0, 0));
            }
            else if(i==2)
            {
                this.jLabelGaragePlayerTurboLevel.setForeground(new java.awt.Color(255, 0, 0));
            }
            else
            {
                //Repaint Car Statistics and money:
                this.RepaintGaragePlayerCharacteristics();
            }
        }
    }//GEN-LAST:event_jButtonGarageTurbosActionPerformed

    private void jButtonGarageTransmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGarageTransmActionPerformed
        if(!enteredGarageEngines && !enteredGarageTurbos && !enteredGarageTransmissions 
                && !enteredGarageNitrous)
        {
            this.enteredGarageTransmissions=true;
            this.jButtonGarageEngines.setText("Back to parts menu!");
            this.jButtonGarageNitrous.setText("Transmission Level 3 - " + 
                    gameGarage.getTransmissionLevel3Price() + "$");
            this.jButtonGarageTransm.setText("Transmission Level 2 - " + 
                     gameGarage.getTransmissionLevel2Price() + "$");
            this.jButtonGarageTurbos.setText("Transmission Level 1 - " + 
                    gameGarage.getTransmissionLevel1Price() + "$");
        }
        else if(enteredGarageEngines)
        {
            int i=gameGarage.buyLevel2Engine(gamePlayer);
            if(i==1)
            {
               this.jLabelPlayerMoney.setForeground(new java.awt.Color(255, 0, 0));
            }
            else if(i==2)
            {
                this.jLabelGaragePlayerEngineLevel.setForeground(new java.awt.Color(255, 0, 0));
            }
            else
            {
                //Repaint Car Statistics and money:
                this.RepaintGaragePlayerCharacteristics();
            }
        }
        else if(enteredGarageNitrous)
        {
            int i=gameGarage.buyLevel2Nitrous(gamePlayer);
            if(i==1)
            {
               this.jLabelPlayerMoney.setForeground(new java.awt.Color(255, 0, 0));
            }
            else if(i==2)
            {
                this.jLabelGaragePlayerNitrousLevel.setForeground(new java.awt.Color(255, 0, 0));
            }
            else
            {
                //Repaint Car Statistics and money:
                this.RepaintGaragePlayerCharacteristics();
            }
        }
        else if(enteredGarageTurbos)
        {
            int i = gameGarage.buyLevel2Turbo(gamePlayer);
            if(i==1)
            {
               this.jLabelPlayerMoney.setForeground(new java.awt.Color(255, 0, 0));
            }
            else if(i==2)
            {
                this.jLabelGaragePlayerTurboLevel.setForeground(new java.awt.Color(255, 0, 0));
            }
            else
            {
                //Repaint Car Statistics and money:
                this.RepaintGaragePlayerCharacteristics();
            }
        }
        else if(enteredGarageTransmissions)
        {
            int i = gameGarage.buyLevel1Transmission(gamePlayer);
            if(i==1)
            {
               this.jLabelPlayerMoney.setForeground(new java.awt.Color(255, 0, 0));
            }
            else if(i==2)
            {
                this.jLabelGaragePlayerTransmLevel.setForeground(new java.awt.Color(255, 0, 0));
            }
            else
            {
                //Repaint Car Statistics and money:
                this.RepaintGaragePlayerCharacteristics();
            }
        }
    }//GEN-LAST:event_jButtonGarageTransmActionPerformed

    private void jButtonGarageNitrousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGarageNitrousActionPerformed
        if(!enteredGarageEngines && !enteredGarageTurbos && !enteredGarageTransmissions 
                && !enteredGarageNitrous)
        {
            this.enteredGarageNitrous=true;
            this.jButtonGarageEngines.setText("Back to parts menu!");
            this.jButtonGarageNitrous.setText("Nitrous Level 3 - " + 
                    gameGarage.getNitrousLevel3Price() + "$");
            this.jButtonGarageTransm.setText("Nitrous Level 2 - " + 
                     gameGarage.getNitrousLevel2Price() + "$");
            this.jButtonGarageTurbos.setText("Nitrous Level 1 - " + 
                    gameGarage.getNitrousLevel1Price() + "$");
        }
        else if(enteredGarageEngines)
        {
            int i = gameGarage.buyLevel3Engine(gamePlayer);
            if(i==1)
            {
               this.jLabelPlayerMoney.setForeground(new java.awt.Color(255, 0, 0));
            }
            else if(i==2)
            {
                this.jLabelGaragePlayerEngineLevel.setForeground(new java.awt.Color(255, 0, 0));
            }
            else
            {
                //Repaint Car Statistics and money:
                this.RepaintGaragePlayerCharacteristics();
            }
        }
        else if(enteredGarageTransmissions)
        {
            int i = gameGarage.buyLevel3Transmission(gamePlayer);
            if(i==1)
            {
               this.jLabelPlayerMoney.setForeground(new java.awt.Color(255, 0, 0));
            }
            else if(i==2)
            {
                this.jLabelGaragePlayerTransmLevel.setForeground(new java.awt.Color(255, 0, 0));
            }
            else
            {
                //Repaint Car Statistics and money:
                this.RepaintGaragePlayerCharacteristics();
            }
        }
        else if(enteredGarageTurbos)
        {
            int i = gameGarage.buyLevel3Turbo(gamePlayer);
            if(i==1)
            {
               this.jLabelPlayerMoney.setForeground(new java.awt.Color(255, 0, 0));
            }
            else if(i==2)
            {
                this.jLabelGaragePlayerTurboLevel.setForeground(new java.awt.Color(255, 0, 0));
            }
            else
            {
                //Repaint Car Statistics and money:
                this.RepaintGaragePlayerCharacteristics();
            }
        }
        else if(enteredGarageNitrous)
        {
            int i = gameGarage.buyLevel3Nitrous(gamePlayer);
            if(i==1)
            {
               this.jLabelPlayerMoney.setForeground(new java.awt.Color(255, 0, 0));
            }
            else if(i==2)
            {
                this.jLabelGaragePlayerNitrousLevel.setForeground(new java.awt.Color(255, 0, 0));
            }
            else
            {
                //Repaint Car Statistics and money:
                this.RepaintGaragePlayerCharacteristics();
            }
        }
    }//GEN-LAST:event_jButtonGarageNitrousActionPerformed

    private void jButtonSafeHouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSafeHouseActionPerformed
        if(!enteredSafeHouse && !enteredPlaceBet)
        {
            //This flag need to be set true before calling HideGamePlay();
            this.enteredSafeHouse = true;
            this.HideGamePlay();
            this.jLabelShiftSyncronizerTab.setForeground(new java.awt.Color(0, 0, 0));
            this.jLabelShiftSyncronizerTab.setText("Player Current Car: " + gamePlayer.getPlayerCar().getCarName());
            this.jLabelCollisionControlTab.setVisible(false);
            this.jLabelPlayerWarning.setText(""); // I am gona use this item.
            this.jButtonPlayerStats.setText("Save Game");
            this.jButtonCarLot.setVisible(false); 
            this.jLabelPlayerMoney.setVisible(false); //I will use the carLot Price label for this;
            this.jButtonSafeHouse.setText("Back to Game!");
            this.jLabelRacesToGo.setText("Total cars: " + this.gamePlayer.getPlayerNumberOfCars());
            //SafeHouse stuff:
            this.jLabelCarLotContent.setVisible(true);
            this.jButtonCarLotNext.setVisible(true);
            this.jButtonCarLotPrevious.setVisible(true);
            this.jLabelCarLotName.setVisible(true);
            this.jLabelCarLotSpecs.setVisible(true);
            this.jLabelCarLotPrice.setVisible(true);
            this.jLabelCarLotPrice.setText("Player Money: " + String.valueOf(this.gamePlayer.getPlayerMoney()) + "$");
            this.jLabelCarLotName.setText(this.gamePlayer.getPlayerCarFromList(0).getCarName());
            this.jLabelCarLotSpecs.setText("Speed: " + String.valueOf(this.gamePlayer.getPlayerCarFromList(0).getCarTopSpeed())
                    + "KMH      Acceleration: " + String.valueOf(this.gamePlayer.getPlayerCarFromList(0).getCarAcceleration()));
            this.jLabelCarLotContent.setIcon(new javax.swing.ImageIcon(this.gamePlayer.getPlayerCarFromList(0).getCarPhotoPath()));
            this.jButtonCarLotBuy.setVisible(true);
            this.jButtonCarLotBuy.setText("Select Car!");
        }
        else if(enteredPlaceBet)
        {
            if(this.gamePlayer.getPlayerMoney()>=this.BetFactor/2)
            {
                this.betPrize = this.BetFactor/2;
                this.jLabelBetPrize.setText("Bet Prize: " + String.valueOf(this.betPrize) + "$");
                this.betSet = true;
                this.jLabelPlayerWarning.setText("");
                this.jLabelPlayerMoney.setForeground(new java.awt.Color(0, 0, 0));
            }
            else
            {
                this.jLabelPlayerWarning.setText("You don't have enough money!");
                this.jLabelPlayerMoney.setForeground(new java.awt.Color(255, 0, 0));
            }
        }
        else
        {
            this.DisplayGamePlay();
            this.enteredSafeHouse = false;
            this.jButtonSafeHouse.setText("SafeHouse");
            this.jButtonPlayerStats.setText("Player Stats");
            this.jLabelPlayerMoney.setVisible(true);
            this.jLabelPlayerWarning.setText("");
            this.jLabelShiftSyncronizerTab.setText("Shift Syncronizer:");
            this.jLabelRacesToGo.setText("Races to go: " + String.valueOf(2-Rival.getPlayerWonTimes()));
            this.jLabelShiftSyncronizerTab.setForeground(new java.awt.Color(0, 0, 255));
            //SafeHouse Stuff:
            this.jLabelCarLotContent.setVisible(false);
            this.jLabelCarLotName.setVisible(false);
            this.jLabelCarLotSpecs.setVisible(false);
            this.jLabelCarLotPrice.setVisible(false);
            this.jButtonCarLotNext.setVisible(false);
            this.jButtonCarLotPrevious.setVisible(false);
            this.jButtonCarLotBuy.setVisible(false);
            this.jButtonCarLotBuy.setText("Buy!");
        }
    }//GEN-LAST:event_jButtonSafeHouseActionPerformed

    private void jButtonPreviousRivalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreviousRivalActionPerformed
        int i;
        if((gamePlayer.getIndexOf(Rival.getOpponentName())-1)>-1)
        {
            i = gamePlayer.getIndexOf(Rival.getOpponentName())-1;
            this.Rival = gamePlayer.getRivalAt(i);
            this.jLabelCar1Icon.setIcon(new javax.swing.ImageIcon(Rival.getOpponentCar().getCarPhotoPath()));
            this.jLabelCarName1.setText(Rival.getOpponentCar().getCarName() + " Statistics");
            this.jLabelSpeedSpecCar1.setText("Top Speed:   " + String.valueOf(Rival.getOpponentCar().getCarTopSpeed()));
            this.jLabelAccSpecCar1.setText("Acceleration:  " + String.valueOf(Rival.getOpponentCar().getCarAcceleration()));
            this.jLabelCPUOpponentName.setText(Rival.getOpponentName());
            this.jLabelDriverXP.setText("Driver XP: " + String.valueOf(Rival.getOpponentExp()));
            this.jLabelCPURivalLosses.setText("Losses: " + String.valueOf(Rival.getDefeatedTimes()));
            this.jLabelCPURivalWins.setText("Wins: " + String.valueOf(Rival.getWinTimes()));
            this.jLabelRacesToGo.setText("Races to go: " + String.valueOf(2-Rival.getPlayerWonTimes()));
            //Calculating race prize:
            this.RacePrize = (1000*(int)Rival.getOpponentExp()/100) + 
                    (Rival.getWinTimes() - Rival.getDefeatedTimes())*50;
            if(this.RacePrize < Rival.getOpponentExp()/2)
            {
                this.RacePrize = Rival.getOpponentExp()/2;
            }
                            this.jLabelRacePrize.setText("Race Prize: " + String.valueOf(this.RacePrize)+"$");
            this.jButtonNextRival.setEnabled(true);
            if(i==0)
            {
                this.jButtonPreviousRival.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jButtonPreviousRivalActionPerformed

    private void jButtonNextRivalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextRivalActionPerformed
        int i;
        if((gamePlayer.getIndexOf(Rival.getOpponentName())+1)<=gamePlayer.getCurrentOpponentIndex())
        {
            i = gamePlayer.getIndexOf(Rival.getOpponentName())+1;
            this.Rival = gamePlayer.getRivalAt(i);
            this.jLabelCar1Icon.setIcon(new javax.swing.ImageIcon(Rival.getOpponentCar().getCarPhotoPath()));
            this.jLabelCarName1.setText(Rival.getOpponentCar().getCarName() + " Statistics");
            this.jLabelSpeedSpecCar1.setText("Top Speed:   " + String.valueOf(Rival.getOpponentCar().getCarTopSpeed()));
            this.jLabelAccSpecCar1.setText("Acceleration:  " + String.valueOf(Rival.getOpponentCar().getCarAcceleration()));
            this.jLabelCPUOpponentName.setText(Rival.getOpponentName());
            this.jLabelDriverXP.setText("Driver XP: " + String.valueOf(Rival.getOpponentExp()));
            this.jLabelCPURivalLosses.setText("Losses: " + String.valueOf(Rival.getDefeatedTimes()));
            this.jLabelCPURivalWins.setText("Wins: " + String.valueOf(Rival.getWinTimes()));
            this.jLabelRacesToGo.setText("Races to go: " + String.valueOf(2-Rival.getPlayerWonTimes()));
            //Calculating race prize:
            this.RacePrize = (1000*(int)Rival.getOpponentExp()/100) + 
                    (Rival.getWinTimes() - Rival.getDefeatedTimes())*50;
            if(this.RacePrize < Rival.getOpponentExp()/2)
            {
                this.RacePrize = Rival.getOpponentExp()/2;
            }
            this.jLabelRacePrize.setText("Race Prize: " + String.valueOf(this.RacePrize)+"$");
            this.jButtonPreviousRival.setEnabled(true);
            if(i==gamePlayer.getCurrentOpponentIndex())
            {
                this.jButtonNextRival.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jButtonNextRivalActionPerformed

    private void jButtonPlaceBetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlaceBetActionPerformed
        if(!enteredPlaceBet && !betSet)
        {
            this.enteredPlaceBet=true;
            this.jButtonMainMenuNewGame.setEnabled(false);
            this.jButtonGarage.setVisible(false);
            this.jButtonStartRace.setVisible(false);
            this.jButtonPreviousRival.setVisible(false);
            this.jButtonNextRival.setVisible(false);
            this.jButtonPlaceBet.setText("Back!");
            if(Rival.getWinTimes()!=0 && Rival.getDefeatedTimes()!=0)
            {
                this.BetFactor = Rival.getOpponentExp()*Rival.getWinTimes()/Rival.getDefeatedTimes();
            }
            else
            {
                this.BetFactor = Rival.getOpponentExp()*4;
            }
            if((Rival.getOpponentExp()/2)<100)
            {
                this.BetFactor = Rival.getOpponentExp()/2;
            }
            this.jButtonCarLot.setText(String.valueOf((int)this.BetFactor)+"$");
            this.jButtonSafeHouse.setText(String.valueOf((int)this.BetFactor/2)+"$");
            this.jButtonPlayerStats.setText(String.valueOf((int)this.BetFactor/4)+"$");
        }
        else if(betSet && !enteredPlaceBet)
        {
            betSet=false;
            this.jButtonPlaceBet.setText("Place Bet");
            betPrize = 0;
            this.BetFactor = 0;
            this.jLabelBetPrize.setText("Bet Prize: ");
        }
        else
        {            
            this.enteredPlaceBet=false;
            this.jButtonMainMenuNewGame.setEnabled(true);
            this.jButtonGarage.setVisible(true);
            this.jButtonStartRace.setVisible(true);
            this.jButtonPreviousRival.setVisible(true);
            this.jButtonNextRival.setVisible(true);
            if(this.betSet==true)
            {
                this.jButtonPlaceBet.setText("Remove Bet");
            }
            else
            {
                this.jButtonPlaceBet.setText("Place Bet");
            }
            this.jButtonCarLot.setText("Car Lot");
            this.jButtonSafeHouse.setText("SafeHouse");
            this.jButtonPlayerStats.setText("Player Stats");
            this.jLabelPlayerWarning.setText("");
            this.jLabelPlayerMoney.setForeground(new java.awt.Color(0, 0, 0));
            if(betSet)
            {
                this.jLabelBetPrize.setText("Bet Prize: " + String.valueOf(this.betPrize) + "$");
            }
            else
            {
                this.jLabelBetPrize.setText("Bet Prize: ");
            }
        }
    }//GEN-LAST:event_jButtonPlaceBetActionPerformed

    private void jButtonMainMenuInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMainMenuInfoActionPerformed
        if(!enteredMainMenuInfo)
        {
            this.enteredMainMenuInfo = true;
            this.jLabelMainMenuInfoLabel.setVisible(true);
            this.jButtonMainMenuLoadGame.setVisible(false);
            this.jButtonMainMenuNewGame.setVisible(false);
            this.jLabelDragRacingLogo.setVisible(false);
            this.jButtonMainMenuInfo.setText("BACK");
        }
        else
        {
            this.enteredMainMenuInfo = false;
            this.jLabelMainMenuInfoLabel.setVisible(false);
            this.jButtonMainMenuLoadGame.setVisible(true);
            this.jButtonMainMenuNewGame.setVisible(true);
            this.jLabelDragRacingLogo.setVisible(true);
            this.jButtonMainMenuInfo.setText("INFO");
        }
        
    }//GEN-LAST:event_jButtonMainMenuInfoActionPerformed

    private void jButtonLoadSaveGameNum1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadSaveGameNum1ActionPerformed
        if(enteredSafeHouse)
        {
            if(this.SaveTheGame(PlayerSaveGame)==0)
            {
                this.jLabelPlayerWarning.setText("Game was successfully saved!");
            }
            else
            {
                this.jLabelPlayerWarning.setText("Saving game error! Check the console!");
            }
            this.jButtonLoadSaveGameNum1.setVisible(false);
            this.jButtonLoadSaveGameNum2.setVisible(false);
            this.jButtonLoadSaveGameNum3.setVisible(false);
        }
        else
        {
            this.readSaveGame(PlayerSaveGame);
            this.DisplayGamePlay();
            this.enteredGamePlay = true;
            this.gamePlayRunning = true;
            this.jButtonLoadSaveGameNum1.setVisible(false);
            this.jButtonLoadSaveGameNum2.setVisible(false);
            this.jButtonLoadSaveGameNum3.setVisible(false);
            this.jButtonMainMenuNewGame.setVisible(true);
            this.jButtonMainMenuLoadGame.setText("LOAD GAME");
            this.enteredMenuLoadGame = false;
        }
    }//GEN-LAST:event_jButtonLoadSaveGameNum1ActionPerformed

    private void jButtonLoadSaveGameNum2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadSaveGameNum2ActionPerformed
        if(enteredSafeHouse)
        {
            if(this.SaveTheGame(PlayerSaveGame2)==0)
            {
                this.jLabelPlayerWarning.setText("Game was successfully saved!");
            }
            else
            {
                this.jLabelPlayerWarning.setText("Saving game error! Check the console!");
            }
            this.jButtonLoadSaveGameNum1.setVisible(false);
            this.jButtonLoadSaveGameNum2.setVisible(false);
            this.jButtonLoadSaveGameNum3.setVisible(false);
        }
        else
        {
            this.readSaveGame(PlayerSaveGame2);
            this.DisplayGamePlay();
            this.enteredGamePlay = true;
            this.gamePlayRunning = true;
            this.jButtonLoadSaveGameNum1.setVisible(false);
            this.jButtonLoadSaveGameNum2.setVisible(false);
            this.jButtonLoadSaveGameNum3.setVisible(false);
            this.jButtonMainMenuNewGame.setVisible(true);
            this.jButtonMainMenuLoadGame.setText("LOAD GAME");
            this.enteredMenuLoadGame = false;
        }
    }//GEN-LAST:event_jButtonLoadSaveGameNum2ActionPerformed

    private void jButtonLoadSaveGameNum3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadSaveGameNum3ActionPerformed
        if(enteredSafeHouse)
        {
            if(this.SaveTheGame(PlayerSaveGame3)==0)
            {
                this.jLabelPlayerWarning.setText("Game was successfully saved!");
            }
            else
            {
                this.jLabelPlayerWarning.setText("Saving game error! Check the console!");
            }
            this.jButtonLoadSaveGameNum1.setVisible(false);
            this.jButtonLoadSaveGameNum2.setVisible(false);
            this.jButtonLoadSaveGameNum3.setVisible(false);
        }
        else
        {
            this.readSaveGame(PlayerSaveGame3);
            this.DisplayGamePlay();
            this.enteredGamePlay = true;
            this.gamePlayRunning = true;
            this.jButtonLoadSaveGameNum1.setVisible(false);
            this.jButtonLoadSaveGameNum2.setVisible(false);
            this.jButtonLoadSaveGameNum3.setVisible(false);
            this.jButtonMainMenuNewGame.setVisible(true);
            this.jButtonMainMenuLoadGame.setText("LOAD GAME");
            this.enteredMenuLoadGame = false;
        }
    }//GEN-LAST:event_jButtonLoadSaveGameNum3ActionPerformed

    private void jTextFieldProfileNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldProfileNameActionPerformed
        String Name = this.jTextFieldProfileName.getText();
        if(!Name.isEmpty())
        {
            gamePlayer.setPlayerProfileName(Name);
            this.jButtonCarLot.setEnabled(true);
            this.jLabelPlayer.setText(this.gamePlayer.getPlayerProfileName());
        }
    }//GEN-LAST:event_jTextFieldProfileNameActionPerformed

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
            java.util.logging.Logger.getLogger(Project44.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Project44.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Project44.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Project44.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Project44().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCarLot;
    private javax.swing.JButton jButtonCarLotBuy;
    private javax.swing.JButton jButtonCarLotNext;
    private javax.swing.JButton jButtonCarLotPrevious;
    private javax.swing.JButton jButtonCollisionControlLeft;
    private javax.swing.JButton jButtonCollisionControlRight;
    private javax.swing.JButton jButtonCollisionControlUp;
    private javax.swing.JButton jButtonGarage;
    private javax.swing.JButton jButtonGarageEngines;
    private javax.swing.JButton jButtonGarageNitrous;
    private javax.swing.JButton jButtonGarageTransm;
    private javax.swing.JButton jButtonGarageTurbos;
    private javax.swing.JButton jButtonLoadSaveGameNum1;
    private javax.swing.JButton jButtonLoadSaveGameNum2;
    private javax.swing.JButton jButtonLoadSaveGameNum3;
    private javax.swing.JButton jButtonMainMenuInfo;
    private javax.swing.JButton jButtonMainMenuLoadGame;
    private javax.swing.JButton jButtonMainMenuNewGame;
    private javax.swing.JButton jButtonMainMenuQuit;
    private javax.swing.JButton jButtonNextRival;
    private javax.swing.JButton jButtonPlaceBet;
    private javax.swing.JButton jButtonPlayerStats;
    private javax.swing.JButton jButtonPreviousRival;
    private javax.swing.JButton jButtonSafeHouse;
    private javax.swing.JButton jButtonShiftSync1;
    private javax.swing.JButton jButtonShiftSync2;
    private javax.swing.JButton jButtonShiftSync3;
    private javax.swing.JButton jButtonStartRace;
    private javax.swing.JLabel jLabelAccSpecCar1;
    private javax.swing.JLabel jLabelAccSpecCarPlayer;
    private javax.swing.JLabel jLabelBetPrize;
    private javax.swing.JLabel jLabelCPUOpponentName;
    private javax.swing.JLabel jLabelCPURivalLosses;
    private javax.swing.JLabel jLabelCPURivalWins;
    private javax.swing.JLabel jLabelCar1Icon;
    private javax.swing.JLabel jLabelCar1RacingStats;
    private javax.swing.JLabel jLabelCar2RacingStats;
    private javax.swing.JLabel jLabelCarLotContent;
    private javax.swing.JLabel jLabelCarLotName;
    private javax.swing.JLabel jLabelCarLotPrice;
    private javax.swing.JLabel jLabelCarLotSpecs;
    private javax.swing.JLabel jLabelCarName1;
    private javax.swing.JLabel jLabelCarName2;
    private javax.swing.JLabel jLabelCollisionControlTab;
    private javax.swing.JLabel jLabelDisplayWinner;
    private javax.swing.JLabel jLabelDragRacingLogo;
    private javax.swing.JLabel jLabelDriverXP;
    private javax.swing.JLabel jLabelFinish;
    private javax.swing.JLabel jLabelGaragePartsInfo;
    private javax.swing.JLabel jLabelGaragePlayerEngineLevel;
    private javax.swing.JLabel jLabelGaragePlayerNitrousLevel;
    private javax.swing.JLabel jLabelGaragePlayerTransmLevel;
    private javax.swing.JLabel jLabelGaragePlayerTurboLevel;
    private javax.swing.JLabel jLabelMainMenuInfoLabel;
    private javax.swing.JLabel jLabelPlayer;
    private javax.swing.JLabel jLabelPlayerCarIcon;
    private javax.swing.JLabel jLabelPlayerMoney;
    private javax.swing.JLabel jLabelPlayerStatsCollisions;
    private javax.swing.JLabel jLabelPlayerStatsPerfectShifts;
    private javax.swing.JLabel jLabelPlayerStatsRacesDrawed;
    private javax.swing.JLabel jLabelPlayerStatsRacesLost;
    private javax.swing.JLabel jLabelPlayerStatsRacesWon;
    private javax.swing.JLabel jLabelPlayerWarning;
    private javax.swing.JLabel jLabelPlayerXP;
    private javax.swing.JLabel jLabelRacePrize;
    private javax.swing.JLabel jLabelRacesToGo;
    private javax.swing.JLabel jLabelShiftSyncronizerTab;
    private javax.swing.JLabel jLabelSpeedSpecCar1;
    private javax.swing.JLabel jLabelSpeedSpecCarPlayer;
    private javax.swing.JLabel jLabelTableStatsCar1;
    private javax.swing.JLabel jLabelTableStatsCar2;
    private javax.swing.JProgressBar jProgressBarCar1;
    private javax.swing.JProgressBar jProgressBarCar2;
    private javax.swing.JTextField jTextFieldProfileName;
    // End of variables declaration//GEN-END:variables
}
