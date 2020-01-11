/*Movie item Detail*/

INSERT INTO `moviecruiser`.`movie` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('1', 'Avatar', '2787965087', '1', '2017-03-15', 'Science Fiction', '1');
INSERT INTO `moviecruiser`.`movie` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('2', 'The Avengers', '1518812988', '1', '2023-12-21', 'Superhero', '0');
INSERT INTO `moviecruiser`.`movie` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('3', 'Titanic', '2187463944', '1', '2025-04-29', 'Romance', '0');
INSERT INTO `moviecruiser`.`movie` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('4', 'Jurassic World', '1671713208', '0', '2019-08-06', 'Science Fiction', '1');
INSERT INTO `moviecruiser`.`movie` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('5', 'Avengers:End Game', '2750760348', '1', '2020-12-29', 'Superhero', '1');

/*User Data Detail*/
INSERT INTO `moviecruiser`.`user` (`us_id`, `us_name`) VALUES ('1', 'Ashu');
INSERT INTO `moviecruiser`.`user` (`us_id`, `us_name`) VALUES ('2', 'Rani');

/*Favorite Detail*/
INSERT INTO `moviecruiser`.`favorite` (`fv_id`, `fv_us_id`, `fv_mo_id`) VALUES ('1', '1', '2');
INSERT INTO `moviecruiser`.`favorite` (`fv_id`, `fv_us_id`, `fv_mo_id`) VALUES ('2', '1', '3');
INSERT INTO `moviecruiser`.`favorite` (`fv_id`, `fv_us_id`, `fv_mo_id`) VALUES ('3', '1', '5');

use moviecruiser;


select us_id, us_name from moviecruiser.user;

select fv_id, fv_us_id, fv_mo_id from moviecruiser.favorite;

/*get movie title name where active is true*/
select movie.mo_title
from moviecruiser.movie
where mo_active = '1';

/*1. 1.	View Movie List Admin (TYUC001)  */
select mo_id, mo_title, mo_box_office, mo_active, mo_date_of_launch, mo_genre, mo_has_teaser from moviecruiser.movie;

/* 2. View Movie List Customer (TYUC002) */
select mo_id, mo_title, mo_box_office, mo_active, mo_date_of_launch, mo_genre, mo_has_teaser from moviecruiser.movie
where mo_active = '1' and
mo_date_of_launch > (SELECT CURRENT_DATE());

/*3. Edit Movie (TYUC003) */
select mo_id, mo_title, mo_box_office, mo_active, mo_date_of_launch, mo_genre, mo_has_teaser from moviecruiser.movie
where mo_id = '1';

update moviecruiser.movie
set
mo_title = 'Joker',
mo_box_office = '236958741',
mo_active = '1',
mo_date_of_launch = '2020-01-01',
mo_genre = 'Thriller',
mo_has_teaser = '1'
where mo_id = '5';

select mo_id, mo_title, mo_box_office, mo_active, mo_date_of_launch, mo_genre, mo_has_teaser from moviecruiser.movie;

/*4. Add to Favorite (TYUC004)  */

insert into moviecruiser.favorite(fv_us_id, fv_mo_id)values(2, 2);
insert into moviecruiser.favorite(fv_us_id, fv_mo_id)values(2, 4);
insert into moviecruiser.favorite(fv_us_id, fv_mo_id)values(2, 5);

/* 5.View Favorite (TYUC005)  */ 
select  mo_title, mo_box_office, mo_active, mo_date_of_launch, mo_genre, mo_has_teaser 
from moviecruiser.movie
inner join moviecruiser.favorite as display_movie on movie.mo_id = favorite.fv_id
where fv_us_id = '1';

select mo_id, mo_title, mo_box_office, mo_active, mo_date_of_launch, mo_genre, mo_has_teaser from moviecruiser.movie;

select count(moviecruiser.favorite.fv_id) as no_of_favorite
from moviecruiser.favorite;

/* 6. Remove Item from Favorite (TYUC006)  */
delete from moviecruiser.favorite
where favorite.fv_us_id = '1' and
favorite.fv_mo_id = '2' limit 1;

select fv_id, fv_us_id, fv_mo_id from moviecruiser.favorite;





