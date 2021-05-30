import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.eclipse.jgit.lib.Repository;
import org.refactoringminer.api.GitHistoryRefactoringMiner;
import org.refactoringminer.api.GitService;
import org.refactoringminer.api.Refactoring;
import org.refactoringminer.api.RefactoringHandler;
import org.refactoringminer.rm1.GitHistoryRefactoringMinerImpl;
import org.refactoringminer.util.GitServiceImpl;


public class HeapSort {
    public static void main(String args[]) throws Exception {
      Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter " + n + " elements :");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        heapSort(arr);
        System.out.println("\nThe sorted array : ");
        System.out.println(Arrays.toString(arr));
        
        
        
    }

    static void heapSort(int arr[]) {
        makeMaxHeap(arr);
        int tmp;
        for (int i = arr.length - 1; i > 0; i--) {
            tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            heapAdjust(arr, 0, i);
        }
    }

    private static void makeMaxHeap(int arr[]) {
        int len = arr.length;
        for (int i = len / 2 - 1; i >= 0; --i) {
            heapAdjust(arr, i, len);
        }
    }

    private static void heapAdjust(int arr[], int i, int n) {
        int j = 2 * i + 1;
        int tmp = arr[i];
        while (j < n) {
            if (j < n - 1 && arr[j] < arr[j + 1])
                j++;
            if (tmp > arr[j])
                break;
            arr[(j - 1) / 2] = arr[j];
            j = 2 * j + 1;
        }
        arr[(j - 1) / 2] = tmp;
    }
}