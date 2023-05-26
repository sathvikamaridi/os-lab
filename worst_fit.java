import java.util.*;
public class WorstFit
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of memory blocks: ");
        int numberOfMemoryBlocks = scanner.nextInt();
        int[] blockSize = new int[numberOfMemoryBlocks];
        for (int i = 0; i < numberOfMemoryBlocks; i++) 
        {
            System.out.println("Enter the size of memory block " + (i+1) + ": ");
            blockSize[i] = scanner.nextInt();
        }
        System.out.println("Enter the number of processes: ");
        int numberOfProcesses = scanner.nextInt();
        int[] processSize = new int[numberOfProcesses];
        for (int i = 0; i < numberOfProcesses; i++) 
        {
            System.out.println("Enter the size of process " + (i + 1) + ": ");
            processSize[i] = scanner.nextInt();
        }
        boolean[] isFree = new boolean[numberOfMemoryBlocks];
        Arrays.fill(isFree, true);
        for (int i = 0; i < processSize.length; i++) 
        {
            int worstFitIndex = -1;
            int worstFitSize = Integer.MIN_VALUE;
            for (int j = 0; j < blockSize.length; j++) 
            {
                if (isFree[j] && blockSize[j] >= processSize[i]) 
                {
                    if (blockSize[j] > worstFitSize) 
                    {
                        worstFitIndex = j;
                        worstFitSize = blockSize[j];
                    }
                }
            }
            if (worstFitIndex != -1) {
                isFree[worstFitIndex] = false;
                System.out.println(" " + (i+1) + "\t\t" + processSize[i] + "\t\t" + (worstFitIndex+1));
            } else {
                System.out.println("Process " + (i+1) + " cannot be allocated memory");
            }
        }
    }
}
