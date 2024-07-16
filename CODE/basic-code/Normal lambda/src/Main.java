import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/*
常见算法:
        查找:
            基本查找:也就是顺序查找,从开头往后一一比较
            二分查找:(有前提要求:数据必须是有序的)每次排查一半的查找范围
            插值查找:二分查找通过改进mid变为插值查找,mid=min+(target-arr[min])/(arr[max]-arr[min]) *(max-min)
            斐波那契查找:也是对二分查找mid进行改进,mid=min+0.618*(max-min)
            分块查找:(分块要求:块内可以无序,块间必须有序,分的块数要等于数字个数.sqrt())先确定数据在哪一块,之后挨个查找
数组API:Arrays:sort排序使用插入排序和二分查找,其中o2和o1分别代表要插入的元素和正在比较的元素
            toString,binarysearch,copyOf,copyOfRange,fill
 */
public class Main {
    public static void main(String[] args) {

    }


    //基本查找
    public static ArrayList<Integer> BaseSearch(int[] arr, int target) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                arrayList.add(i);
            }
        }
        return arrayList;
    }

    //二分查找
    public static boolean BinarySearch(int[] arr, int target) {
        int min = 0;
        int max = arr.length - 1;
        while (true) {
            if (arr[min] > target || arr[max] < target) {
                return false;
            }
            if (min > max) {
                return false;
            }
            int mid = (min + max) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }

        }
    }

    //分块查找
    public void BlockSearch(int[] arr, int target) {
        //分块操作
        Block b1 = new Block(1, 10, 0, 2);
        //之后管理块
        Block[] blocks = {b1};
        //之后进行逻辑查找,比较target与每个块的max值,可以遍历block[]的max值进行比较

    }

    class Block {
        private int min;
        private int max;
        private int startIndex;
        private int endIndex;


        public Block() {
        }

        public Block(int min, int max, int startIndex, int endIndex) {
            this.min = min;
            this.max = max;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        /**
         * 获取
         *
         * @return min
         */
        public int getMin() {
            return min;
        }

        /**
         * 设置
         *
         * @param min
         */
        public void setMin(int min) {
            this.min = min;
        }

        /**
         * 获取
         *
         * @return max
         */
        public int getMax() {
            return max;
        }

        /**
         * 设置
         *
         * @param max
         */
        public void setMax(int max) {
            this.max = max;
        }

        /**
         * 获取
         *
         * @return startIndex
         */
        public int getStartIndex() {
            return startIndex;
        }

        /**
         * 设置
         *
         * @param startIndex
         */
        public void setStartIndex(int startIndex) {
            this.startIndex = startIndex;
        }

        /**
         * 获取
         *
         * @return endIndex
         */
        public int getEndIndex() {
            return endIndex;
        }

        /**
         * 设置
         *
         * @param endIndex
         */
        public void setEndIndex(int endIndex) {
            this.endIndex = endIndex;
        }

        public String toString() {
            return "Block{min = " + min + ", max = " + max + ", startIndex = " + startIndex + ", endIndex = " + endIndex + "}";
        }
    }
}