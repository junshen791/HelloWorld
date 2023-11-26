package pro4;

import java.util.Random;

/**
 * @author liu
 * @date 2023/11/22 10:49
 */
public class Test {

        public static void main(String[] args) {
            String password = generateRandomPassword();

            // 创建密码破解线程
            Thread crackerThread = new Thread(new PasswordCrackerThread(password));
            crackerThread.start();

            // 创建日志线程（守护线程）
            Thread loggerThread = new Thread(new LoggerThread());
            loggerThread.setDaemon(true); // 将日志线程设置为守护线程
            loggerThread.start();
        }

        private static String generateRandomPassword() {
            Random random = new Random();
            StringBuilder password = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                char randomChar = (char) (random.nextInt(26) + 'a');
                password.append(randomChar);
            }
            return password.toString();
        }
    }

    class PasswordCrackerThread implements Runnable {
        private final String password;

        PasswordCrackerThread(String password) {
            this.password = password;
        }

        @Override
        public void run() {
            // 使用穷举法进行密码破解
            for (char c1 = 'a'; c1 <= 'z'; c1++) {
                for (char c2 = 'a'; c2 <= 'z'; c2++) {
                    for (char c3 = 'a'; c3 <= 'z'; c3++) {
                        String attempt = "" + c1 + c2 + c3;
                        if (attempt.equals(password)) {
                            System.out.println("Password cracked! The password is: " + attempt);
                            return;
                        }
                        // 记录尝试的密码
                        LoggerThread.log(attempt);
                    }
                }
            }
        }
    }

    class LoggerThread implements Runnable {
        private static StringBuilder log = new StringBuilder();

        static void log(String attempt) {
            log.append(attempt).append(", ");
        }

        @Override
        public void run() {
            // 定期打印尝试的密码
            while (true) {
                try {
                    Thread.sleep(5000); // 5秒钟打印一次
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Attempts so far: " + log.toString());
            }
        }
    }


