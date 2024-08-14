class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            people.add(new Person(names[i], heights[i]));
        }
        people.sort(Comparator.comparing(person -> -person.height));
        String[] result = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            result[i] = people.get(i).name;
        }
        return result;
    }
}

class Person {
    String name;
    int height;

    public Person(String name, int height) {
        this.name = name;
        this.height = height;
    }
}