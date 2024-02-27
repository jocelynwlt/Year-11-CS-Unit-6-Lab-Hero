import java.lang.Math;
public class Hero {
    public String name;
    public int hitPoints;

    public Hero(String name){
        this.hitPoints=100;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getHitPoints(){
        return hitPoints;
    }

    public String toString(){
        return "Hero{name='"+name+ "', hitPoints="+hitPoints+"}";
    }

    public void attack(Hero opponent){
        double random = Math.random();
        if(random<0.5){
            opponent.hitPoints = hitPoints-10;
        }
        else{
            hitPoints-=10;
        }
    }

    public void senzuBean(){
        hitPoints = 100;
    }

    private void fightUntilTheDeathHelper(Hero opponent){
        while (opponent.hitPoints>0 && this.hitPoints>0){
            this.attack(opponent);
        }
    }

    public String fightUntilTheDeath(Hero opponent){
        opponent.senzuBean();
        this.senzuBean();
        fightUntilTheDeathHelper(opponent);
        return name+": "+hitPoints+"    " +opponent.name+": "+hitPoints;
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n){
        int[] results = new int[2];
        for(int i=0; i<n; i++){
            senzuBean();
            opponent.senzuBean();
            fightUntilTheDeath(opponent);
            if(hitPoints<=0){
                results[0]++;
            } else{
                results[1]++;
            }
        }
        return results;
    }

    public String nFightsToTheDeath(Hero opponent, int n){
        int[] results= nFightsToTheDeathHelper(opponent, n);
        if(results[0]>results[1]){
            return opponent.name+": "+results[0]+ " wins \n"+this.name+": "+results[1]+" wins \n"+ opponent.name+" wins!";
        }
        else if(results[1]>results[0]){
            return opponent.name+": "+results[0]+ " wins \n"+this.name+": "+results[1]+" wins \n"+ this.name+" wins!";
        }
        else{
            return opponent.name+": "+results[0]+ " wins \n"+this.name+": "+results[1]+" wins \n"+"OMG! It was actually a draw!";
        }
    }
    public void dramaticFightToTheDeath(Hero opponent) throws InterruptedException {
        senzuBean();
        opponent.senzuBean();
        while(hitPoints>0&&opponent.hitPoints>0){
            attack(opponent);
            Thread.sleep(1000);
            System.out.println(this);
            System.out.println(opponent);
        }
        if(hitPoints<=0){
            System.out.println(opponent.name+" wins!");
        } else{
            System.out.println(this.name+" wins!");
        }

    }
}
