private static Integer stepNr = 0;
    private static void binarySearch(Integer[] arr, Integer leftEnd, Integer rigthEnd, Integer value){
        stepNr++;
        Integer mid = (leftEnd + rigthEnd) / 2;
        if(value < arr[mid]) binarySearch(arr, leftEnd, mid, value);
        else if(value > arr[mid]) binarySearch(arr, mid, rigthEnd, value);
        else if(value == arr[mid]) System.out.println(stepNr);
    }
    
	public static void main(String[] args) {
		Integer[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
		binarySearch(arr, 0, arr.length, 13);
	}
}
