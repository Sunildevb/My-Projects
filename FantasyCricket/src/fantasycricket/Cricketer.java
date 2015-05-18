/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fantasycricket;

import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Sunildev Birbal
 * @registration number 12/0719/2653
 */
public class Cricketer extends JPanel {

    private final MySQL sql = new MySQL();
    private ResultSet cricketerstat;
    private String playerfname;
    private String playerlname;
    private String playerteam;
    private String playerrole;
    private String playernationality;
    private int playerid;
    private String bats;
    private String bowls;
    private int id;
    private JPanel cricketer = new JPanel();
    private GridLayout layout = new GridLayout(2, 5);

    public void Player() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //sql.Connect();
        sql.setResults("SELECT * FROM cricketersinfo where ID =" + id);
        this.cricketerstat = sql.getResult();
        while (cricketerstat.next()) {
            this.playerfname = cricketerstat.getString("FirstName");
            this.playerlname = cricketerstat.getString("LastName");
            this.playerteam = cricketerstat.getString("Team");
            this.playerrole = cricketerstat.getString("Role");
            this.playernationality = cricketerstat.getString("Nationality");
            this.playerid = Integer.parseInt(cricketerstat.getString("ID"));
            this.bats = cricketerstat.getString("Bats");
            this.bowls = cricketerstat.getString("Bowls");

            //  String playercost = data.getString("Cost");
            // System.out.println(playerfname + playerlname + playerteam + playerrole);
        }

    }

    public JPanel CricketerCard() {

        cricketer.setLayout(layout);
        cricketer.add(new JLabel(playerfname));
        cricketer.add(new JLabel(playerlname));
        cricketer.add(new JButton("Button 3"));
        cricketer.add(new JButton("Long-Named Button 4"));
        cricketer.add(new JButton("5"));
        
        cricketer.validate();
        return cricketer;

    }

    public String getPlayerfname() {
        return playerfname;
    }

    public String getPlayerlname() {
        return playerlname;
    }

    public String getPlayerteam() {
        return playerteam;
    }

    public String getPlayerrole() {
        return playerrole;
    }

    public int getPlayerid() {
        return playerid;
    }

    public String getBats() {
        return bats;
    }

    public String getBowls() {
        return bowls;
    }

    public String getPlayernationality() {
        return playernationality;
    }

    public void setId(int id) throws SQLException {
        try {
            sql.Connect();
            this.id = id;
            try {
                Player();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                Logger.getLogger(Cricketer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Cricketer.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql.CloseConn();
    }

}
