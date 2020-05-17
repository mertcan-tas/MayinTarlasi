package com.mayintarlasi;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MayinButton extends JButton {

    public int value = 0;
    public boolean isMarked = false;
    public int genislik=16;
    public int yukseklik=16;
    public boolean isChecked=false;
    public int posX;
    public int posY;
    public boolean isMine=false;
    
    Resim icon = Resim._bilinmeyen;
    ImageIcon imageIcon=new ImageIcon(icon.getPath());
    
    public MayinButton() {
        this.setSize(genislik, yukseklik);
        this.setContentAreaFilled(false);
        this.setVisible(true);
        setButtonImage(icon);
    }
    
    public void SetMayinImage(){ //butona göre resim
        if(this.value==0)
            setButtonImage(Resim._0);
        if(this.value==1)
            setButtonImage(Resim._1);
        if(this.value==2)
            setButtonImage(Resim._2);
        if(this.value==3)
            setButtonImage(Resim._3);
        if(this.value==4)
            setButtonImage(Resim._4);
        if(this.value==5)
            setButtonImage(Resim._5);
        if(this.value==6)
            setButtonImage(Resim._6);
        if(this.value==7)
            setButtonImage(Resim._7);
        if(this.value==8)
            setButtonImage(Resim._8);
    }

    public ImageIcon setImageSize(int width, int height) {
        Image image = imageIcon.getImage(); 
        Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);    
        return imageIcon;
    }

    public enum Resim {

        _bilinmeyen(System.getProperty("user.dir") + "/src/com/mayintarlasi/sources/bilinmeyen.png"),
        _0(System.getProperty("user.dir") + "/src/com/mayintarlasi/sources/sifir.png"),
        _1(System.getProperty("user.dir") + "/src/com/mayintarlasi/sources/bir.png"),
        _2(System.getProperty("user.dir") + "/src/com/mayintarlasi/sources/iki.png"),
        _3(System.getProperty("user.dir") + "/src/com/mayintarlasi/sources/uc.png"),
        _4(System.getProperty("user.dir") + "/src/com/mayintarlasi/sources/dort.png"),
        _5(System.getProperty("user.dir") + "/src/com/mayintarlasi/sources/bes.png"),
        _6(System.getProperty("user.dir") + "/src/com/mayintarlasi/sources/alti.png"),
        _7(System.getProperty("user.dir") + "/src/com/mayintarlasi/sources/yedi.png"),
        _8(System.getProperty("user.dir") + "/src/com/mayintarlasi/sources/sekiz.png"),
        _bayrak(System.getProperty("user.dir") + "/src/com/mayintarlasi/sources/bayrak.png"),
        _bomba(System.getProperty("user.dir") + "/src/com/mayintarlasi/sources/bomba.png");
        
        private String path;

        Resim(String path) {
            this.path = path;
        }
        
        public String getPath() {
            return path;
        }

    }

    public void setButtonImage(Resim icon) {
        this.icon = icon;
        imageIcon=new ImageIcon(icon.getPath());
        imageIcon=setImageSize(genislik, yukseklik);
        this.setIcon(imageIcon);
    }


}
