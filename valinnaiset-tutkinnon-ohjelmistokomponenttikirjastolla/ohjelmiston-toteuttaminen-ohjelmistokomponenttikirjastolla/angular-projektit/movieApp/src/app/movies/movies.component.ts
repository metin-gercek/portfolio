import { Component, OnInit } from '@angular/core';
import { Movie } from '../movie';
import { Movies } from '../movie.datasource';

@Component({
  selector: 'movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {
  title = 'Movie List';
  
  movies = Movies;
  selectedMovie!: Movie;

  getTitle() {
    return this.title;
  }

  onSelect(movie:Movie): void {
    this.selectedMovie = movie;
  }

  constructor() { }

  ngOnInit(): void {
  }

}
