package com.zerock.movie.repository;

import com.zerock.movie.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT m, MAX(mi), AVG(COALESCE(r.grade, 0)), COUNT(DISTINCT r) " +
            "FROM Movie m " +
            "LEFT OUTER JOIN Review r " +
            "ON m = r.movie " +
            "LEFT OUTER JOIN MovieImage mi " +
            "ON m = mi.movie " +
            "GROUP BY m")
    Page<Object[]> getListPage(Pageable pageable);
}
