package org.basix.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/*
* Stream 2 type ki hoti hai
* 1. Intermediate : map, filter, peek, skip, limit, dropWhile | ye always new stream return krte rehte hai tranformation k liye
* 2. Terminal : forEach. Reducers | ye end kr deta iss bakchodiu ko
*
* Customizing Stream : map,flatMap,filter,limit,skip,peek,sorted,distinct
* Reducers(reduce a stream of objects to a single object): count,anyMatch(predicate),allMatch(predicate),noneMatch(predicate),
*                                                           findFirst,findAny,min(comparator),max(comparator)
* */
public class StreamsDemo {

    public static void collectorK(){
        /*
        * Collector are used to get data from stream in a datastructure
        * */
        List<Movie> movies = List.of(
                new Movie("a",10,Genre.ACTION),
                new Movie("b",29,Genre.ACTION),
                new Movie("c", 30,Genre.COMEDY),
                new Movie("d",29,Genre.HORROR),
                new Movie("e",28,Genre.THRILLER)
        );

        /*var result = movies.stream()
                    .filter(movie -> movie.getLikes() > 10)
                    .collect(Collectors.toList());*/
        /*var result = movies.stream()
                    .filter(movie -> movie.getLikes() > 10)
                      //Movie::getLikes === movie -> movie.getLikes()
                    .collect(Collectors.toMap(Movie::getTitle,Movie::getLikes));*/

        /*var result = movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .collect(Collectors.summarizingInt(Movie::getLikes));*/

        /*var result = movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .map(Movie::getTitle)
                .collect(Collectors.joining(" | "));

        System.out.println(result);*/

        // ** Grouping Elements
        /*var result = movies.stream().
                        collect(Collectors.groupingBy(Movie::getGenre, Collectors.counting()));*/

       /* var result = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre,
                        Collectors.mapping(Movie::getTitle,Collectors.joining(","))
                ));*/

        var result = movies.stream()
                .collect(Collectors.partitioningBy(movie -> movie.getLikes() > 10,
                Collectors.mapping(Movie::getTitle,Collectors.joining(", "))));

        System.out.println(result);
    }

    public static void reducerD(){
        List<Movie> movies = List.of(
               /* new Movie("a",10),
                new Movie("b",29),
                new Movie("c", 30),
                new Movie("d",29),
                new Movie("e",28)*/
        );

       /* var result = movies.stream().anyMatch(movie -> movie.getLikes() >20); // can apply allMatch, noneMatch
        System.out.println(result);*/

        /*var result = movies.stream().findAny().get(); // can apply findFirst
        System.out.println(result.getTitle());*/

        /*var result = movies.stream().max(Comparator.comparing(Movie::getLikes)).get(); // can apply min too
        System.out.println(result.getTitle());*/

        //
       /* var result = movies.stream()
                .map(Movie::getLikes)
//                .peek(m-> System.out.println(m))
                .reduce((a,b)-> a + b)
                .get(); // this can cause null error to prevent this
        System.out.println("Total Likes: "+result);*/

        // to prevent null erro by using get() we can use orElse()
       /* var result = movies.stream()
                .map(Movie::getLikes)
                .reduce(Integer::sum);

        System.out.println(result.orElse(0));*/

       /* var result = movies.stream()
                .map(Movie::getLikes)
                .reduce(0,Integer::sum);
        System.out.println(result);*/
    }

    public static void slicingAndSort(){
        /*
        * Slicing Stream have 4 ways: limit(n), skip(n), takeWhile(predicate),dropWhile(predicate)
        * */
        List<Movie> movies = List.of(
               /* new Movie("a",10),
                new Movie("b",29),
                new Movie("c", 30),
                new Movie("d",29),
                new Movie("e",28)*/
                );


//        movies.stream().limit(2).forEach(n-> System.out.println(n.getTitle()));
        // pagination logic: skip( (poge - 1) x pageSize)
//        movies.stream().skip(2).forEach(n-> System.out.println(n.getTitle()));

        // **filter() sare dataset pr iterate krta hai, ye sala bus condition satisfy hote hi ruk jata hai, aage data check nhi krta
//        movies.stream().takeWhile(m->m.getLikes()<30).forEach(n-> System.out.println(n.getTitle()));


        // **opposite of takeWhile,
//        movies.stream().dropWhile(m->m.getLikes()<30).forEach(n-> System.out.println(n.getTitle()));

        // **Sorting
     /*   movies.stream()
               // .sorted((a,b)->a.getTitle().compareTo(b.getTitle())) // old fashioned, lot of code
                .sorted(Comparator.comparing(Movie::getTitle).reversed())
                .forEach(movie -> System.out.println(movie.getTitle()));*/

        // **Unique elements
        /*movies.stream().map(Movie::getLikes)
                .distinct()
                .forEach(System.out::println);*/

        // ** peeking whats going on in middle of operation | also use for troubleshoot
        movies.stream().filter(m->m.getLikes() >10)
                .peek(m-> System.out.println("Filterd: "+m.getTitle())) // filter hone k baad kya thi value
                .map(Movie::getTitle)
                .peek(t-> System.out.println("Mapped: "+t)) // map k baad kya thi value
                .forEach(System.out::println);


    }

    public static void createStream(){
        /*
        * Both methods creates a stream
        * Streams data store nhi krte collection jese, to heavy dataset bhi use kr skte hai
        * */
        var stream = Stream.of(1,2,3,4,5); // basic stream
        var stream2 = Stream.generate(()->Math.random());
        stream2.limit(3).forEach(n -> System.out.println(n));

        Stream.iterate(1,n -> n +1).limit(5).forEach(n-> System.out.println(n)); // no store, direct run

    }

    public static void show(){
        /*
        * Collection Bade water tank jese hai, jisme values stored hai,
        * or stream usse nikle pipe jese hai, jissme water flow krta hai, har ghr k liye
        * */
        List<Movie> movies = List.of(
              /*  new Movie("a",10),
                new Movie("b",15),
                new Movie("c", 20)*/
        );

        // Imperative Programming | how things should be done
        int count = 0;
        for (var movie : movies){
            if(movie.getLikes() > 10){
                count++;
            }
        }

        // Declaretive ( Functional) Programming | what needs to be done
        var count2 = movies
                .stream()
                .filter(movie -> movie.getLikes() > 10)
                .count();
        //        System.out.println(count2);

        // Filter ka predicate alag nikal skte hai
        Predicate<Movie> haslike = movie -> movie.getLikes() < 10;
        movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .forEach(n-> System.out.println(n.getTitle()));


        // we can use Map Method to represent dat
//        movies.stream().map(movie -> movie.getTitle()).forEach(mov-> System.out.println(mov));
        movies.stream().map(Movie::getTitle).forEach(mov-> System.out.println(mov)); // methods reference

        // We also have flatMap method in stream, which convert multiple dimension array to single one
        // Logic to flat : Stream<T<t>> -> Stream<t>
        var steam = Stream.of(List.of(1,2,3,4),List.of(5,6,7,8,9));
//        steam.forEach(s-> System.out.println(s)); // return 2 arrays
//        steam.flatMap(st -> st.stream()).forEach(s-> System.out.println(s)); // returns individual value from each array

        //Streams can only be used on collections, directly primitive value ko stream fucntion accessible nahi hota
        int [] nums = {1,2,4,5};
//        Arrays.stream(nums).forEach(n-> System.out.println(n));
    }
}
