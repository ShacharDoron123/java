
    public static Node<Integer> createList(Integer[] arr) {
        if (arr == null || arr.length == 0)
            return null;

        Node<Integer> head = new Node<>(arr[0]);
        Node<Integer> last = head;

        for (int i = 1; i < arr.length; i++) {
            Node<Integer> temp = new Node<>(arr[i]);
            last.setNext(temp);
            last = temp;
        }

        return head;
    }

    public static void printList(Node<Integer> lst) {
        Node<Integer> p = lst;
        while (p != null) {
            System.out.print(p.getValue() + "--> ");
            p = p.getNext();
        }
        System.out.println("null");
    }

    public static void printListR(Node<Integer> lst) {
        if (lst == null) {
            System.out.println("null");
            return;
        }
        System.out.print(lst.getValue() + "--> ");
        printListR(lst.getNext());
    }

    public static void printListRReverse(Node<Integer> lst) {
        if (lst == null) return;
        printListRReverse(lst.getNext());
        System.out.println(lst.getValue());
    }

    public static <T> int countList(Node<T> lst) {
        int count = 0;
        Node<T> p = lst;
        while (p != null) {
            count++;
            p = p.getNext();
        }
        return count;
    }

    public static <T> int countListR(Node<T> lst) {
        if (lst == null) return 0;
        return 1 + countListR(lst.getNext());
    }

    public static int sumList(Node<Integer> lst) {
        int sum = 0;
        Node<Integer> p = lst;
        while (p != null) {
            sum += p.getValue();
            p = p.getNext();
        }
        return sum;
    }

    public static int sumListR(Node<Integer> lst) {
        if (lst.getNext() == null) return lst.getValue();
        return lst.getValue() + sumListR(lst.getNext());
    }

    public static boolean isExit(Node<Integer> lst, int val) {
        Node<Integer> p = lst;
        while (p != null) {
            if (p.getValue() == val) return true;
            p = p.getNext();
        }
        return false;
    }

    public static boolean isExitR(Node<Integer> lst, int val) {
        if (lst == null) return false;
        if (lst.getValue() == val) return true;
        return isExitR(lst.getNext(), val);
    }

    public static int maxInLst(Node<Integer> lst) {
        int max = lst.getValue();
        Node<Integer> p = lst;
        while (p != null) {
            if (p.getValue() > max) max = p.getValue();
            p = p.getNext();
        }
        return max;
    }

    public static int maxInLstR(Node<Integer> lst) {
        return maxInLstR(lst, -999);
    }

    private static int maxInLstR(Node<Integer> lst, int max) {
        if (lst == null) return max;
        if (lst.getValue() > max) max = lst.getValue();
        return maxInLstR(lst.getNext(), max);
    }

    public static Node<Integer> makeAllPos(Node<Integer> lst) {
        Node<Integer> p = lst;
        while (p != null) {
            p.setValue(Math.abs(p.getValue()));
            p = p.getNext();
        }
        return lst;
    }

    public static Node<Integer> makeAllPosR(Node<Integer> lst) {
        if (lst == null) return null;
        lst.setValue(Math.abs(lst.getValue()));
        lst.setNext(makeAllPosR(lst.getNext()));
        return lst;
    }

    public static Node<Integer> getElement(Node<Integer> lst, int index) {
        Node<Integer> p = lst;
        int c = 1;
        if (index < 1) return null;
        while (p != null && c < index) {
            p = p.getNext();
            c++;
        }
        return p;
    }

    public static Node<Integer> getElementR(Node<Integer> lst, int index) {
        if (lst == null || index < 1) return null;
        if (index == 1) return lst;
        return getElementR(lst.getNext(), index - 1);
    }

    public static boolean compareList(Node<Integer> a, Node<Integer> b) {
        if (countList(a) != countList(b)) return false;
        while (a != null) {
            if (!a.getValue().equals(b.getValue())) return false;
            a = a.getNext();
            b = b.getNext();
        }
        return true;
    }

    public static boolean compareListR(Node<Integer> a, Node<Integer> b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (!a.getValue().equals(b.getValue())) return false;
        return compareListR(a.getNext(), b.getNext());
    }

    public static boolean isSorted(Node<Integer> lst) {
        if (lst == null || lst.getNext() == null) return true;
        Node<Integer> p = lst;
        while (p.getNext() != null) {
            if (p.getValue() > p.getNext().getValue()) return false;
            p = p.getNext();
        }
        return true;
    }

    public static boolean isSortedR(Node<Integer> lst) {
        if (lst == null || lst.getNext() == null) return true;
        if (lst.getValue() > lst.getNext().getValue()) return false;
        return isSortedR(lst.getNext());
    }

    public static int seq(Node<Integer> lst, int num) {
        Node<Integer> p = lst;
        int count = 0;
        while (p != null) {
            if (p.getValue() == num) {
                count++;
                while (p != null && p.getValue() == num) {
                    p = p.getNext();
                }
            } else {
                p = p.getNext();
            }
        }
        return count;
    }

    public static void printIndexToIndex(Node<Integer> lst, int start, int end) {
        Node<Integer> p = lst;
        int index = 0;
        while (p != null && index < start) {
            index++;
            p = p.getNext();
        }
        while (p != null && start <= end) {
            System.out.println(p);
            p = p.getNext();
        }
    }

    public static int longestNegativeSeq(Node<Integer> lst) {
        int current = 0;
        int max = 0;
        Node<Integer> p = lst;
        while (p != null) {
            if (p.getValue() < 0) {
                current++;
                if (current > max) max = current;
            } else {
                current = 0;
            }
            p = p.getNext();
        }
        return max;
    }

    public static Node<Integer> removeDuplicates(Node<Integer> lst) {
        Node<Integer> newList = null;
        Node<Integer> tail = null;

        while (lst != null) {
            Node<Integer> p = newList;
            boolean exists = false;

            while (p != null && !exists) {
                if (p.getValue().equals(lst.getValue()))
                    exists = true;
                p = p.getNext();
            }

            if (!exists) {
                Node<Integer> newNode = new Node<>(lst.getValue());
                if (newList == null) {
                    newList = newNode;
                    tail = newNode;
                } else {
                    tail.setNext(newNode);
                    tail = newNode;
                }
            }

            lst = lst.getNext();
        }

        return newList;
    }

    public static Node<Integer> Insert(Node<Integer> lst, int val) {
        Node<Integer> newNode = new Node<>(val);
        if (lst == null || val <= lst.getValue()) {
            newNode.setNext(lst);
            return newNode;
        }
        Node<Integer> p = lst;
        while (p.getNext() != null && p.getNext().getValue() < val) {
            p = p.getNext();
        }
        newNode.setNext(p.getNext());
        p.setNext(newNode);
        return lst;
    }

    public static Node<Integer> mergeLists(Node<Integer> l1, Node<Integer> l2) {
        Node<Integer> head = null;
        Node<Integer> tail = null;

        while (l1 != null && l2 != null) {
            int val;
            if (l1.getValue() <= l2.getValue()) {
                val = l1.getValue();
                l1 = l1.getNext();
            } else {
                val = l2.getValue();
                l2 = l2.getNext();
            }

            Node<Integer> newNode = new Node<>(val);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.setNext(newNode);
                tail = newNode;
            }
        }

        while (l1 != null) {
            tail.setNext(new Node<>(l1.getValue()));
            tail = tail.getNext();
            l1 = l1.getNext();
        }

        while (l2 != null) {
            tail.setNext(new Node<>(l2.getValue()));
            tail = tail.getNext();
            l2 = l2.getNext();
        }

        return head;
    }

    public static void addAfter(Node<Integer> head, int val) {
        Node<Integer> p = head;
        while (p != null) {
            if (p.getValue() == val) {
                Node<Integer> temp = new Node<>(val + 1);
                temp.setNext(p.getNext());
                p.setNext(temp);
                return;
            }
            p = p.getNext();
        }
    }

    public static Node<Integer> merge(Node<Integer> lst1, Node<Integer> lst2) {
        Node<Integer> result = null;
        Node<Integer> last = null;
        Node<Integer> p1 = lst1;
        while (p1 != null) {
            if (isExit(lst2, p1.getValue()) && !isExit(result, p1.getValue())) {
                Node<Integer> temp = new Node<>(p1.getValue());
                if (result == null) {
                    result = temp;
                    last = temp;
                } else {
                    last.setNext(temp);
                    last = temp;
                }
            }
            p1 = p1.getNext();
        }
        return result;
    }

    public static void question19(Node<Integer> head) {
        if (head == null) return;

        int length = 0;
        Node<Integer> temp = head;
        while (temp != null) {
            length++;
            temp = temp.getNext();
        }

        if (length % 2 == 0) {
            int mid1Index = length / 2 - 1;
            temp = head;
            for (int i = 0; i < mid1Index; i++)
                temp = temp.getNext();

            int firstMid = temp.getValue();
            int secondMid = temp.getNext().getValue();

            System.out.println(Math.max(firstMid, secondMid));
        } else {
            int first = head.getValue();

            temp = head;
            while (temp.getNext() != null)
                temp = temp.getNext();

            int last = temp.getValue();

            System.out.println(first);
            System.out.println(last);
        }
    }

    public static Node<Integer> question21(Node<Integer> chain1, Node<Integer> chain2) {
        int deletedCount = 0;

        while (chain1 != null && exists(chain2, chain1.getValue())) {
            chain1 = chain1.getNext();
            deletedCount++;
        }

        Node<Integer> current = chain1;
        Node<Integer> prev = null;

        while (current != null) {
            if (exists(chain2, current.getValue())) {
                prev.setNext(current.getNext());
                deletedCount++;
            } else {
                prev = current;
            }
            current = current.getNext();
        }

        if (chain1 == null)
            return new Node<>(deletedCount);

        current = chain1;
        while (current.getNext() != null)
            current = current.getNext();

        current.setNext(new Node<>(deletedCount));

        return chain1;
    }

    public static boolean exists(Node<Integer> head, int value) {
        while (head != null) {
            if (head.getValue() == value) return true;
            head = head.getNext();
        }
        return false;
    }
