package hashCodeEquals;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ItemTest {

    @Test
    public void hashSetTestWithWrongHashCode() {

        ItemIncorrect wrong1 = new ItemIncorrect(1);
        ItemIncorrect wrong2 = new ItemIncorrect(1);
        ItemIncorrect wrong3 = new ItemIncorrect(2);

        Set<ItemIncorrect> wrongSet = new HashSet<>();
        wrongSet.add(wrong1);
        wrongSet.add(wrong2);
        wrongSet.add(wrong3);

        System.out.println(wrongSet);

        Assert.assertTrue(wrongSet.contains(wrong1));
        Assert.assertTrue(wrongSet.contains(wrong3));
        Assert.assertTrue(wrongSet.size() == 2);
    }

    @Test
    public void hashMapTestWithWrongHashCode() {

        ItemIncorrect wrong1 = new ItemIncorrect(1);
        ItemIncorrect wrong2 = new ItemIncorrect(1);
        ItemIncorrect wrong3 = new ItemIncorrect(2);

        Map<ItemIncorrect, String> wrongMap = new HashMap<>();

        wrongMap.put(wrong1, "will be added");
        wrongMap.put(wrong2, "will replace wrong1");
        wrongMap.put(wrong3, "will be added wrong 3");

        //wrong2, wrong3
        Assert.assertTrue(wrongMap.size() == 2);
    }

    @Test
    public void hashSetTestWithCorretHashCode() {
        ItemCorrect wrong1 = new ItemCorrect(1);
        ItemCorrect wrong2 = new ItemCorrect(2);
        ItemCorrect wrong3 = new ItemCorrect(3);

        Set<ItemCorrect> correctSet = new HashSet<>();
        correctSet.add(wrong2);
        correctSet.add(wrong3);
        correctSet.add(wrong1);

        System.out.println(correctSet);
    }

    @Test
    public void hashMapTestWithCorretHashCode() {
        ItemCorrect wrong1 = new ItemCorrect(1);
        ItemCorrect wrong2 = new ItemCorrect(2);
        ItemCorrect wrong3 = new ItemCorrect(3);

        Map<ItemCorrect,String> correctMap = new HashMap<>();
        correctMap.put(wrong2,"wrong2");
        correctMap.put(wrong3,"wrong3");
        correctMap.put(wrong1,"wrong1");

        System.out.println(correctMap);
    }

}