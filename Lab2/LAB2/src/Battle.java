import java.util.ArrayList;
import java.util.Collections;

public class Battle implements BattleInterface{
    private Character player1;
    private Character player2;
    private ArrayList<Gear> gearList;

    public Battle(Character ch1, Character ch2, ArrayList<Gear> gearList) {
        if (gearList.size() != 10) throw new IllegalArgumentException("the size of the gearlist should be 10");
        this.player1 = ch1;
        this.player2 = ch2;
        this.gearList = gearList;
    }


    private void assignGear(ArrayList<Gear> gearList, Character player){
        Collections.sort(gearList);
        Collections.reverse(gearList);
        for (int i = 0; i < gearList.size(); i++) {
            Gear tmp = gearList.get(i);
            GEAR_TYPE tmpType = tmp.getType();
            if (tmpType == GEAR_TYPE.HEAD_GEAR){
                if (player.getHeadGearList().size() < 1){
                    player.setGear(tmp);
                    gearList.remove(i);
                    return;
                }
            } else if (tmpType == GEAR_TYPE.FOOTWEAR) {
                if (player.getFootWearList().size() < 2){
                    player.setGear(tmp);
                    gearList.remove(i);
                    return;
                }
            }
            else{
                if( player.getHandGearList().size() < 2){
                    player.setGear(tmp);
                    gearList.remove(i);
                    return;
                }
            }
        }
        // if this character does not have any slots
        // Just assign the first gear since it's the one has most attack or defense
        Gear firstGear = gearList.get(0);
        player.setGear(firstGear);
        gearList.remove(0);
    }

    @Override
    public void start() {
        while (gearList.size() != 0){
            this.assignGear(gearList, this.player1);
            this.assignGear(gearList, this.player2);
            System.out.println(player1);
            System.out.println(player2);
        }
        if (player1.compareTo(player2) > 0){
            System.out.println(player1.getName() + " win!");
        } else if (player1.compareTo(player2) < 0) {
            System.out.println(player2.getName() + " win!");
        } else{
            System.out.println("There is a tie.");
        }

    }
}
