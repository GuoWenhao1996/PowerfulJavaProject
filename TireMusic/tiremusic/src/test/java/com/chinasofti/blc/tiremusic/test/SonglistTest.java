package com.chinasofti.blc.tiremusic.test;

import java.util.List;

import org.junit.Test;

import com.chinasofti.blc.tiremusic.songlist.entity.MusicInSongList;
import com.chinasofti.blc.tiremusic.songlist.entity.SongList;
import com.chinasofti.blc.tiremusic.songlist.service.SongListService;

/**
 * 歌单模块单元测试代码
 * 
 * @author guowh
 *
 */
public class SonglistTest {
	SongListService songListService = new SongListService();

	/**
	 * 根据用户id查找歌单列表
	 */
	@Test
	public void testQueryAllListByUid() {
		List<SongList> lists = songListService.queryAllListByUid(1);
		for (SongList songList : lists) {
			System.out.println(songList);
		}
	}

	/**
	 * 增加歌单测试
	 */
	@Test
	public void testAddSonglist() {
		// System.out.println(songListService.addSongList("增加歌单测试", 1));
		// System.out.println(songListService.addSongList(null, 1));
		// System.out.println(songListService.addSongList("", 1));
		// System.out.println(songListService.addSongList(" ", 1));
		System.out.println(songListService.addSongList("               aaa", 1));
	}

	/**
	 * 增加50条歌单
	 */
	@Test
	public void testAddManySonglist() {
		for (int i = 0; i < 50; i++) {
			System.out.println(songListService.addSongList("测试歌单" + (i + 1), 1));
		}
	}

	/**
	 * 修改歌单
	 */
	@Test
	public void testUpdateSonglist() {
		System.out.println(songListService.updateSongListByLid("2", "修改测试1", 1));
	}

	/**
	 * 删除歌单
	 */
	@Test
	public void testDeleteSonglist() {
		System.out.println(songListService.deleteSongListByLid("2"));
	}

	/**
	 * 收藏歌曲
	 */
	@Test
	public void testAddMusicToList() {
		System.out.println(songListService.addMusicToList(1, 4));
		System.out.println(songListService.addMusicToList(2, 4));
		System.out.println(songListService.addMusicToList(3, 4));
	}

	/**
	 * 移除收藏歌曲
	 */
	@Test
	public void testDeleteMusicInList() {
		System.out.println(songListService.deleteMusicInList("1", "3"));
	}

	/**
	 * 收藏歌曲的列表
	 */
	@Test
	public void testShowAllMusicByListId() {
		List<MusicInSongList> lists = songListService.showAllMusicByListId(4);
		for (MusicInSongList musicInSongList : lists) {
			System.out.println(musicInSongList);
		}
	}

}
