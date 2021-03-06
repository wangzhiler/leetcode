package leetcodeJava;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists {


    /*
        1. priority queue [推荐]

        l1: 2 3  4   5
        l2: 8 10 11
        l3: 0 7  9
        l4: 1 99 100

        每个list的第一个add [排序]
        result加一个poll出来的 把被poll的list下一个add [排序]
        循环

     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        for (ListNode list : lists) {
            if (list!=null) {
                queue.add(list);
            }
        }
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null) {
                queue.add(cur.next);
            }
        }
        return dummy.next;
    }





    /*
        2. 分治 融合
        time:O(nlogk) where k is the number of linked list
        space:O(n)

        l1: 2 3  4 5
        l2: 8 10 11 ->m
                            ->return
        l3: 0 7  9
        l4: 1 99 100 ->n
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if(lists==null||lists.length==0) return null;
        return sort(lists, 0, lists.length - 1);
    }

    // 把所有的list不停划分
    private ListNode sort(ListNode[] lists, int low, int high) {
        if (low >= high) {
            return lists[low];
        }

        int mid = (high - low) / 2 + low;
        ListNode l1 = sort(lists, low, mid);
        ListNode l2 = sort(lists, mid + 1, high);

        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if (l1.val == l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}


