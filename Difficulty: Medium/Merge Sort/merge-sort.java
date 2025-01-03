//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            new Solution().mergeSort(arr, 0, arr.length - 1);

            for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    private void merge(int arr[],int low,int mid,int high){
        int size=high-low+1;
        int [] temp=new int [size];
        int left=low;
        int right=mid+1;
        int index=0;
        
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp[index++]=arr[left++];
                
            }else{
                temp[index++]=arr[right++];
            }
        }
        while(left<=mid){
            temp[index++]=arr[left++];
        }
        while(right<=high){
            temp[index++]=arr[right++];
        }
        System.arraycopy(temp,0,arr,low,size);
    }
    void mergeSort(int arr[], int l, int r) {
        if(l<r){
            int mid=(l+r)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr,l,mid,r);
        }
        
    }
}