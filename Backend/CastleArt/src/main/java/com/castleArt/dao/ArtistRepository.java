package com.castleArt.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.castleArt.entities.Artist;

@Repository
@Transactional
public interface ArtistRepository extends JpaRepository<Artist, Integer> {

	//public Artist findByartistNameIgnoreCase(String artistName);
	public Artist findById(int artistId);
	//public Artist findByName(String artistName); 
	public List<Artist> findByFirstNameContaining(String firstName);

	@Query(
			value = "SELECT * FROM artist where status=true and availiblity=true",
			nativeQuery = true)
	public List<Artist> findServiceArtist();


	@Modifying
	@Query(value="delete from artist a where a.artist_id=:artistId", nativeQuery = true)
	public int deleteArtist(int artistId);
	
	
	@Query(value="select * from artist a where a.username=:username and a.password=:password",nativeQuery = true)
	public Artist findByUsernameAndPassword(String username, String password);
	
	@Query(value="select * from artist a where a.username=:username",nativeQuery = true)
	public Artist findArtistByUsername(String username);
	
}
