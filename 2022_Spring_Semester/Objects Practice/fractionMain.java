public class fractionMain {
    public static void main(String[] args) {
        fraction b=new fraction(2,8);
        System.out.println(b);
        System.out.println(b.getNum());
        System.out.println(b.getDenom());
        b.setNum(5);
        b.setNum(10);
        System.out.println(b);
        System.out.println(b.getNum());
        System.out.println(b.getDenom());
        System.out.println(b.add(new fraction(1,2)));
        System.out.println(b.equals(new fraction(3,3)));
    }
}
