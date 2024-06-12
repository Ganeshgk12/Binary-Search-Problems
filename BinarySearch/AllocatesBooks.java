package Programs.striverz.BinarySearch;

public class AllocatesBooks {
    public static void main(String[] args) {
        int [] books = {25, 46, 28, 49, 24};
        int students = 4;
        System.out.println(allocateBooksOptimal(books,students));
    }
    //Optimal

    public static int allocateBooksOptimal(int [] books,int students) {
        int n = books.length;
        if (students > n) return -1;

        int low = 0;
        int high = 0;

        for (int x : books) {
            low = Math.max(low,x);
            high += x;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (countStudents(books,mid,students) > students) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;

    }
    // Brute Force
    public static int allocateBooks (int [] books,int students) {
        int n = books.length;
        if (students > n) return -1;

        int low = 0;
        int high = 0;

        for (int x : books) {
            low = Math.max(low,x);
            high += x;
        }
        for (int i = low; i <= high ; i++) {
            if (countStudents(books,i,students) == students){
                return i;
            }
        }
        return low;
    }

    private static int countStudents (int [] books,int pages,int students) {
        int n = books.length;
        int countStudents = 1;
        long countPages = 0;

        for (int i = 0; i < n; i++) {
            if (countPages + books[i] <= pages) {
                countPages += books[i];
            }else {
                countStudents++;
                countPages = books[i];
            }
        }
        return countStudents;
    }
}
