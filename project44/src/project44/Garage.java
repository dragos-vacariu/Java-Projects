/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project44;

/**
 *
 * @author Black2
 */
public class Garage {
    private final int EngineLevel1Price;
    private final int EngineLevel2Price;
    private final int EngineLevel3Price;
    private final int TransmissionLevel1Price;
    private final int TransmissionLevel2Price;
    private final int TransmissionLevel3Price;
    private final int NitrousLevel1Price;
    private final int NitrousLevel2Price;
    private final int NitrousLevel3Price;
    private final int TurboLevel1Price;
    private final int TurboLevel2Price;
    private final int TurboLevel3Price;
    public Garage()
    {
        this.EngineLevel1Price = 4000;
        this.EngineLevel2Price = 8000;
        this.EngineLevel3Price = 12000;
        this.NitrousLevel1Price = 6500;
        this.NitrousLevel2Price = 8000;
        this.NitrousLevel3Price = 11000;
        this.TransmissionLevel1Price = 2000;
        this.TransmissionLevel2Price = 5000;
        this.TransmissionLevel3Price = 7500;
        this.TurboLevel1Price = 8500;
        this.TurboLevel2Price = 11500;
        this.TurboLevel3Price = 15000;
    }
    public int buyLevel1Engine(Player p1)
    {
        if(p1.getPlayerMoney()>=this.EngineLevel1Price && p1.getPlayerCar().EngineLevel<1)
        {
            p1.getPlayerCar().EngineLevel1Upgrade();
            p1.decreasePlayerMoney(EngineLevel1Price);
            return 0;
        }
        else if(p1.getPlayerMoney()<this.EngineLevel1Price)
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }
    public int buyLevel2Engine(Player p1)
    {
        if(p1.getPlayerMoney()>=this.EngineLevel2Price && p1.getPlayerCar().EngineLevel<2)
        {
            p1.getPlayerCar().EngineLevel2Upgrade();
            p1.decreasePlayerMoney(EngineLevel2Price);
            return 0;
        }
        else if(p1.getPlayerMoney()<this.EngineLevel2Price)
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }
    public int buyLevel3Engine(Player p1)
    {
        if(p1.getPlayerMoney()>=this.EngineLevel3Price && p1.getPlayerCar().EngineLevel<3)
        {
            p1.getPlayerCar().EngineLevel3Upgrade();
            p1.decreasePlayerMoney(EngineLevel3Price);
            return 0;
        }
        else if(p1.getPlayerMoney()<this.EngineLevel3Price)
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }
    public int buyLevel1Transmission(Player p1)
    {
        if(p1.getPlayerMoney()>=this.TransmissionLevel1Price && p1.getPlayerCar().TransmissionLevel<1)
        {
            p1.getPlayerCar().TransmissionLevel1Upgrade();
            p1.decreasePlayerMoney(TransmissionLevel1Price);
            return 0;
        }
        else if(p1.getPlayerMoney()<this.TransmissionLevel1Price)
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }
    public int buyLevel2Transmission(Player p1)
    {
        if(p1.getPlayerMoney()>=this.TransmissionLevel2Price && p1.getPlayerCar().TransmissionLevel<2)
        {
            p1.getPlayerCar().TransmissionLevel2Upgrade();
            p1.decreasePlayerMoney(TransmissionLevel2Price);
            return 0;
        }
        else if(p1.getPlayerMoney()<this.TransmissionLevel2Price)
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }
    public int buyLevel3Transmission(Player p1)
    {
        if(p1.getPlayerMoney()>=this.TransmissionLevel3Price && p1.getPlayerCar().TransmissionLevel<3)
        {
            p1.getPlayerCar().TransmissionLevel3Upgrade();
            p1.decreasePlayerMoney(TransmissionLevel3Price);
            return 0;
        }
        else if(p1.getPlayerMoney()<this.TransmissionLevel3Price)
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }
    public int buyLevel1Turbo(Player p1)
    {
        if(p1.getPlayerMoney()>=this.TurboLevel1Price && p1.getPlayerCar().TurboLevel<1)
        {
            p1.getPlayerCar().TurboLevel1Upgrade();
            p1.decreasePlayerMoney(TurboLevel1Price);
            return 0;
        }
        else if(p1.getPlayerMoney()<this.TurboLevel1Price)
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }
    public int buyLevel2Turbo(Player p1)
    {
        if(p1.getPlayerMoney()>=this.TurboLevel2Price && p1.getPlayerCar().TurboLevel<2)
        {
            p1.getPlayerCar().TurboLevel2Upgrade();
            p1.decreasePlayerMoney(TurboLevel2Price);
            return 0;
        }
        else if(p1.getPlayerMoney()<this.TurboLevel2Price)
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }
    public int buyLevel3Turbo(Player p1)
    {
        if(p1.getPlayerMoney()>=this.TurboLevel3Price && p1.getPlayerCar().TurboLevel<3)
        {
            p1.getPlayerCar().TurboLevel3Upgrade();
            p1.decreasePlayerMoney(TurboLevel3Price);
            return 0;
        }
        else if(p1.getPlayerMoney()<this.TurboLevel3Price)
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }
    public int buyLevel1Nitrous(Player p1)
    {
        if(p1.getPlayerMoney()>=this.NitrousLevel1Price && p1.getPlayerCar().NitrousLevel<1)
        {
            p1.getPlayerCar().NitrousLevel1Upgrade();
            p1.decreasePlayerMoney(NitrousLevel1Price);
            return 0;
        }
        else if(p1.getPlayerMoney()<this.NitrousLevel1Price)
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }
    public int buyLevel2Nitrous(Player p1)
    {
        if(p1.getPlayerMoney()>=this.NitrousLevel2Price && p1.getPlayerCar().NitrousLevel<2)
        {
            p1.getPlayerCar().NitrousLevel2Upgrade();
            p1.decreasePlayerMoney(NitrousLevel2Price);
            return 0;
        }
        else if(p1.getPlayerMoney()<this.NitrousLevel2Price)
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }
    public int buyLevel3Nitrous(Player p1)
    {
        if(p1.getPlayerMoney()>=this.NitrousLevel3Price && p1.getPlayerCar().NitrousLevel<3)
        {
            p1.getPlayerCar().NitrousLevel3Upgrade();
            p1.decreasePlayerMoney(NitrousLevel3Price);
            return 0;
        }
        else if(p1.getPlayerMoney()<this.NitrousLevel3Price)
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }
    public int getEngineLevel1Price()
    {
        return this.EngineLevel1Price;
    }
    public int getEngineLevel2Price()
    {
        return this.EngineLevel2Price;
    }
    public int getEngineLevel3Price()
    {
        return this.EngineLevel3Price;
    }
    public int getTurboLevel1Price()
    {
        return this.TurboLevel1Price;
    }
    public int getTurboLevel2Price()
    {
        return this.TurboLevel2Price;
    }
    public int getTurboLevel3Price()
    {
        return this.TurboLevel3Price;
    }
    public int getTransmissionLevel1Price()
    {
        return this.TransmissionLevel1Price;
    }
    public int getTransmissionLevel2Price()
    {
        return this.TransmissionLevel2Price;
    } 
    public int getTransmissionLevel3Price()
    {
        return this.TransmissionLevel3Price;
    }
    public int getNitrousLevel1Price()
    {
        return this.NitrousLevel1Price;
    }
    public int getNitrousLevel2Price()
    {
        return this.NitrousLevel2Price;
    }
    public int getNitrousLevel3Price()
    {
        return this.NitrousLevel3Price;
    }
}
