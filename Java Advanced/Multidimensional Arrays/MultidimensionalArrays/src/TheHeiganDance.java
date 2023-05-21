import java.util.Scanner;

public class TheHeiganDance {
    private static int[] currentPosition = new int[2];
    public static void main(String[] args) {
        int playerHealth = 18500;
        double heiganHealth = 3_000_000;
        double cloudDamage = 3500;
        double eruptionDamage = 6000;

        currentPosition[0] = 7;
        currentPosition[1] = 7;

        Scanner scanner = new Scanner(System.in);

        var damage = Double.parseDouble(scanner.nextLine());

        var currentSpell = scanner.nextLine();
        var lastSpell = "";
        var cloudActive = false;

        while(playerHealth > 0 && heiganHealth > 0){
            //Boss takes hit
            heiganHealth -= damage;

            //checks if boss is dead
            if (heiganHealth <= 0) {
                if (cloudActive) {
                    playerHealth -= cloudDamage;
                    cloudActive = false;
                }
                continue;
            }

            //Cloud second hit
            if (cloudActive) {
                playerHealth -= cloudDamage;
                cloudActive = false;
            }
            if (playerHealth <= 0) continue;

            var spellInfo = currentSpell.split("\\s+");
            var spell = spellInfo[0];
            var spellRow = Integer.parseInt(spellInfo[1]);
            var spellCol = Integer.parseInt(spellInfo[2]);

            // if player in spell area
            if(playerInSpellArea(currentPosition[0], currentPosition[1], spellRow, spellCol)){
                if (!playerMoved(currentPosition[0], currentPosition[1], spellRow, spellCol)){
                    if(spell.equals("Cloud")){
                        playerHealth -= cloudDamage;
                        cloudActive = true;
                    } else {
                        playerHealth -= eruptionDamage;
                    }
                }
            }

            lastSpell = spell;

            if(playerHealth <= 0){
                break;
            }

            currentSpell = scanner.nextLine();
        }

        if(heiganHealth <= 0){
            System.out.println("Heigan: Defeated!");
        }else{
            System.out.printf("Heigan: %.2f\n", heiganHealth);
        }

        if (playerHealth <= 0){
            System.out.printf("Player: Killed by %s\n", lastSpell.equals("Cloud") ? "Plague Cloud" : "Eruption");
        } else {
            System.out.printf("Player: %d\n", playerHealth);
        }

        System.out.printf("Final position: %d, %d\n", currentPosition[0], currentPosition[1]);
    }

    private static boolean playerMoved(int currentRow, int currentCol, int spellRow, int spellCol){
        var moved = false;
        // Move up
        if(currentRow - 1 >= 0 && currentRow - 1 < 15 && !playerInSpellArea(currentRow - 1, currentCol, spellRow, spellCol)){
            currentRow--;
            moved = true;
        } else if (currentCol + 1 >= 0 && currentCol + 1 < 15 && !playerInSpellArea(currentRow, currentCol + 1, spellRow, spellCol)) { //Move left
            currentCol++;
            moved = true;
        } else if(currentRow + 1 >= 0 && currentRow + 1 < 15 && !playerInSpellArea(currentRow + 1, currentCol, spellRow, spellCol)){
            currentRow++;
            moved = true;
        } else if (currentCol - 1 >= 0 && currentCol - 1 < 15 && !playerInSpellArea(currentRow, currentCol - 1, spellRow, spellCol)) { //Move left
            currentCol--;
            moved = true;
        }

        currentPosition[0] = currentRow;
        currentPosition[1] = currentCol;
        return moved;
    }

    private static boolean playerInSpellArea(int currentRow, int currentCol, int spellRow, int spellCol){
        return currentRow >= spellRow - 1 && currentRow <= spellRow + 1 &&
                currentCol >= spellCol - 1 && currentCol <= spellCol + 1;
    }
}