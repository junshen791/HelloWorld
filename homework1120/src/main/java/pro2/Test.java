package pro2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author liu
 * @date 2023/11/20 10:10
 */
public class Test {
        public static void main(String[] args) {
            String directoryPath = "your_directory_path";
            File directory = new File(directoryPath);

            if (directory.exists() && directory.isDirectory()) {
                ExecutorService executorService = Executors.newFixedThreadPool(5);
                List<Future<File>> futures = new ArrayList<>();

                // 遍历目录
                File[] files = directory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isDirectory()) {
                            Future<File> future = executorService.submit(() -> findMaxMinFile(file));
                            futures.add(future);
                        }
                    }
                }

                // 等待所有线程完成
                for (Future<File> future : futures) {
                    try {
                        File result = future.get();
                        System.out.println("Max file in " + result.getParent() + ": " + result.getName());
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                }
                executorService.shutdown();
            }
        }
        private static File findMaxMinFile(File directory) {
            return null;
        }
    }

