import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> logsDuration = new TreeMap<>();
        Map<String, Set<String>> logsIps = new HashMap<>();

        var counter = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < counter; i++) {
            var input = scanner.nextLine().split("\\s+");
            var ip = input[0];
            var user = input[1];
            var duration = Integer.parseInt(input[2]);

            if (!logsDuration.containsKey(user)){
                logsDuration.put(user, 0);
                logsIps.put(user, new TreeSet<>());
            }
            logsDuration.put(user, logsDuration.get(user) + duration);
            logsIps.get(user).add(ip);

        }

        logsDuration.forEach((u, d) -> {
            System.out.printf("%s: %d [%s]%n", u, d, String.join(", ", logsIps.get(u)));
        });
    }
}