/*

You are given an ascending array with rotation
such as [4,5,6,0,1,2,3]

Questions involving this array:
1. find the index of rotation. In our case, it is 3 because arr[3] = 0
2. given a number t, return the index of t in this array or -1 if t is not in the array

Q1 is solved by the function rotation_recursive() and/or rotation_iterative(). Both can solve the problem correctly; the difference is that one is implemented with recursion while the other one uses loop. Our implementation applies to the cases when:
1) the array has duplicates (i.e., non-strictly monototically ascending with rotation);
2) the array is fully sorted (e.g., [0,1,2,3,4,5,6]. The function will return 0 then).

Q2 is solved by the function rotation_and_find_recursive() and/or rotation_and_find_iterative(). Again, both can solve the problem correctly; the difference is that one is implemented with recursion while the other one uses loop. 
Our implementation applies to the cases when:
1) the array has duplicates (i.e., non-strictly monototically ascending with rotation);
2) the array is fully sorted;
3) the target number t is not in the array. [return -1 to indicate that].

*/


public class RotationArray {
    public static void main(String[] args) {
        
        int[] myList = {4,0,1,2,3};
        int answer = rotation_and_find_iterative(myList, -2);
        System.out.println(answer);
        if(answer!=-1){
            System.out.println(myList[answer]);
        }
    }
    
    // Applicable to non-strictly ascending arr with at most 1 rotation
    public static int rotation_recursive(int[] arr, int l, int r){
        if(l > r){
            return -1;
        }
        
        // arr is fully sorted in the closed interval [l, r]
        if(arr[l] <= arr[r]){
            return l;
        }
        
        int mid = (l+r)/2;
        
        if(arr[l]<=arr[mid]){
            return rotation_recursive(arr, mid+1, r);
        }
        else{
            return rotation_recursive(arr, l, mid);
        }       
    }
    
    // Applicable to non-strictly ascending arr with at most 1 rotation
    public static int rotation_iterative(int[] arr){
        int l=0;
        int r=arr.length-1;
        
        if(l > r){
            return -1;
        } //empty arr
        
        while(arr[l] > arr[r]){
            int mid = (l+r)/2;
            
            if(arr[l]<=arr[mid]){
                l = mid+1;
            }
            else{
                r = mid;
            }       
            
        }
        
        return l;
    }


    // Applicable to non-strictly ascending arr with at most 1 rotation
    public static int rotation_and_find_recursive(int[] arr, int l, int r, int target){
        if(l > r){
            return -1;
        }
        
        int mid = (l+r)/2;
        
        if(arr[mid] == target){
            return mid;
        }
        
        if(arr[l]<=arr[mid]){ /* sorted at [l, mid] */
            if(arr[l]<=target && target<arr[mid]){
                return rotation_and_find_recursive(arr, l, mid-1, target);
            }
            else{
                return rotation_and_find_recursive(arr, mid+1, r, target);
            }          
        }
        else{   /* sorted at [mid, r] */
            if(arr[mid]<target && target<=arr[r]){
                return rotation_and_find_recursive(arr, mid, r, target);
            }
            else{
                return rotation_and_find_recursive(arr, l, mid-1, target);
            }
        }       
    }
    
    // Applicable to non-strictly ascending arr with at most 1 rotation
    public static int rotation_and_find_iterative(int[] arr, int target){
        int l = 0;
        int r = arr.length-1;
           
        while(l<=r){
            int mid = (l+r)/2;

            if(arr[mid] == target){
                return mid;
            }

            if(arr[l]<=arr[mid]){ /* sorted at [l, mid] */
                if(arr[l]<=target && target<arr[mid]){
                    r = mid-1;
                }
                else{
                    l = mid+1;
                }          
            }
            else{   /* sorted at [mid, r] */
                if(arr[mid]<target && target<=arr[r]){
                    l = mid;
                }
                else{
                    r = mid-1;
                }
            }       
        }
        
        return -1;
            
    }



}
