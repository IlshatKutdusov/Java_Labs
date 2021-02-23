package Lab2;

interface IConst1 {
    static final int verConst = 101;
}

interface IConst2 {
    int verConst = 102;
}

interface IConstN extends IConst1, IConst2 {
    static final int verConst = 100;

    int get(boolean b);
}

class ClassIntN implements IConstN {
    public int get(boolean b) {
        return b ? IConst1.verConst : IConst2.verConst;
    }
}

public class Example3 {
    public static void main(String[] args) {
        ClassIntN cI = new ClassIntN();
        System.out.print("cI.verConst= " + cI.verConst);
        System.out.println(" ClassInt.verConst= " + ClassIntN.verConst);
        //-----
        IConst1 iC1 = cI;
        System.out.print("iC1.verConst= " + iC1.verConst);
        IConst2 iC2 = cI;
        System.out.print(" iC2.verConst= " + iC2.verConst);
        IConstN iC = cI;
        System.out.println(" iC.verConst= " + iC.verConst);
        //--------------
        System.out.print("IConst1.verConst= " + IConst1.verConst);
        System.out.print(" IConst2.verConst= " + IConst2.verConst);
        System.out.println(" IConst.verConst= " + IConstN.verConst);
        //--------------
        System.out.println("cI.get(true)= " + cI.get(true) + " cI.get(false)= " + cI.get(false));
    }
}

/*
Result:
cI.verConst= 100 ClassInt.verConst= 100
iC1.verConst= 101 iC2.verConst= 102 iC.verConst= 100
IConst1.verConst= 101 IConst2.verConst= 102 IConst.verConst= 100
cI.get(true)= 101 cI.get(false)= 102
*/