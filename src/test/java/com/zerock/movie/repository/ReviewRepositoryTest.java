package com.zerock.movie.repository;

import com.zerock.movie.entity.Member;
import com.zerock.movie.entity.Movie;
import com.zerock.movie.entity.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;


    @Test
    public void insertMovieReviews() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            // 영화 번호
            Long mno = (long)(Math.random() * 100) + 1;

            // 리뷰어 번호
            Long mid = (long) ((Math.random() * 100) + 1);

            Member member = Member.builder()
                    .mid(mid)
                    .build();

            Review review = Review.builder()
                    .member(member)
                    .movie(Movie.builder().mno(mno).build())
                    .grade((int)(Math.random() * 5) + 1)
                    .text("이 영화에 대한 평가..." + i)
                    .build();

            reviewRepository.save(review);
        });
    }
}