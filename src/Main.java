public class Main {
    public static void main(String[] args) {
        Segment A = new Segment(new Point(0,0), new Point(100,50));
        Segment[] B = A.perpendicularSegment(A,A.getEnd());
        System.out.println(A.ToSvg());
        System.out.println(B[0].ToSvg());
        System.out.println(B[1].ToSvg());
    }
}