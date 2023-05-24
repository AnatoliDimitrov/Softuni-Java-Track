import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> logs = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);

        var input = scanner.nextLine();

        while (!input.equals("end")){
            var log = input.split("\\s+");
            var ip = log[0].split("=")[1];
            var user = log[2].split("=")[1];

            if(!logs.containsKey(user)){
                logs.put(user, new LinkedHashMap<>());
            }

            if(!logs.get(user).containsKey(ip)){
                logs.get(user).put(ip, 0);
            }

            logs.get(user).put(ip, logs.get(user).get(ip) + 1);

            input = scanner.nextLine();
        }

        logs.forEach((user, ips) -> {
            System.out.printf("%s:%n", user);
            var i = 0;
            var result = "";
            for (var ip:ips.entrySet()){
                result = String.format("%s => %d", ip.getKey(), ip.getValue());
                if (i < ips.size() - 1){
                    result += ",";
                } else {
                    result += ".";
                }
                System.out.printf(result + " ");
                i++;
            }
            System.out.println();
        });
    }
}