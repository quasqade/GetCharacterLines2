package logic;

import common.Chapter;

import java.util.*;

/**
 * Shamelessly taken from SDSE by BlackDragonHunt
 */
public class ChapterMap
{
	private Map<Chapter, List<String>> map;

	public ChapterMap()
	{
		map = new HashMap<>();

		List<String> buffer;

		//Prologue
		map.put(Chapter.PROLOGUE, Arrays.asList("e00_001_000.lin",
				"e00_002_000.lin",
				"e00_003_001.lin",
				"e00_004_003.lin",
				"e00_004_001.lin",
				"e00_005_004.lin",
				"e00_006_007.lin",
				"script_pak_e00_0000.lin"));

		//Chapter 1
		map.put(Chapter.CHAPTER1_EL, Arrays.asList("e01_001_007.lin",
				"e01_001_103.lin",
				"e01_002_101.lin",
				"e01_002_146.lin",
				"e01_003_135.lin",
				"e01_004_135.lin",
				"e01_005_103.lin",
				"e01_006_101.lin",
				"e01_006_103.lin",
				"e01_006_135.lin",
				"e01_006_136.lin",
				"e01_006_137.lin",
				"e01_006_139.lin",
				"e01_006_146.lin",
				"e01_007_001.lin",
				"e01_007_003.lin",
				"e01_007_004.lin",
				"e01_007_005.lin",
				"e01_007_010.lin",
				"e01_008_001.lin",
				"e01_008_003.lin",
				"e01_008_004.lin",
				"e01_008_005.lin",
				"e01_008_006.lin",
				"e01_008_009.lin",
				"e01_008_010.lin",
				"e01_008_014.lin",
				"e01_008_015.lin",
				"e01_008_016.lin",
				"e01_008_101.lin",
				"e01_008_103.lin",
				"e01_008_135.lin",
				"e01_008_136.lin",
				"e01_008_137.lin",
				"e01_008_139.lin",
				"e01_008_146.lin",
				"e01_009_001.lin",
				"e01_009_003.lin",
				"e01_009_004.lin",
				"e01_009_005.lin",
				"e01_009_006.lin",
				"e01_009_009.lin",
				"e01_009_010.lin",
				"e01_009_014.lin",
				"e01_009_015.lin",
				"e01_009_016.lin",
				"e01_009_101.lin",
				"e01_009_103.lin",
				"e01_009_135.lin",
				"e01_009_136.lin",
				"e01_009_137.lin",
				"e01_009_139.lin",
				"e01_009_146.lin",
				"e01_011_103.lin",
				"e01_011_101.lin",
				"e01_012_135.lin",
				"e01_013_001.lin",
				"e01_013_003.lin",
				"e01_013_101.lin",
				"e01_014_009.lin",
				"e01_015_001.lin",
				"e01_015_003.lin",
				"e01_015_004.lin",
				"e01_015_101.lin",
				"e01_016_014.lin",
				"e01_017_101.lin",
				"e01_018_103.lin",
				"e01_019_101.lin",
				"e01_019_119.lin",
				"e01_020_101.lin",
				"e01_020_119.lin",
				"e01_021_101.lin",
				"e01_021_135.lin",
				"e01_022_104.lin",

				//Generic text
				"e01_000_146.lin",
				"script_pak_e01_0000.lin",
				"script_pak_e01_0023.lin"
				));
		map.put(Chapter.CHAPTER1_NL, Arrays.asList("e01_023_006.lin",
				"e01_022_006.lin",
				"e01_024_006.lin",
				"e01_025_104.lin",
				"e01_025_106.lin",
				"e01_027_104.lin",
				"e01_029_104.lin",
				"e01_024_001.lin",
				"e01_024_015.lin",
				"e01_024_101.lin",
				"e01_024_003.lin",
				"e01_024_004.lin",
				"e01_024_010.lin",
				"e01_024_014.lin",
				"e01_024_016.lin",
				"e01_024_139.lin",
				"e01_024_146.lin",
				"e01_031_119.lin",
				"e01_032_009.lin",
				"e01_033_135.lin",
				"e01_034_136.lin",
				"e01_035_135.lin",
				"e01_036_137.lin",
				"e01_037_101.lin",
				"e01_038_137.lin",
				"e01_038_156.lin",
				"e01_038_138.lin",
				"e01_039_006.lin",
				"e01_255_000.lin",
				"e01_040_001.lin",
				"e01_040_201.lin",
				"e01_040_203.lin"
				));
		map.put(Chapter.CHAPTER1_TRIAL, Arrays.asList("e01_101_000.lin",
				"e01_150_000.lin",
				"nonstop_01_001.dat",
				"e01_102_000.lin",
				"e01_103_000.lin",
				"nonstop_01_002.dat",
				"e01_104_000.lin",
				"e01_105_000.lin",
				"e01_151_000.lin",
				"nonstop_01_003.dat",
				"e01_106_000.lin",
				"e01_107_000.lin",
				"e01_154_000.lin",
				"e01_108_000.lin",
				"anagram_11.dat",
				"e01_109_000.lin",
				"e01_152_000.lin",
				"nonstop_01_004.dat",
				"e01_110_000.lin",
				"e01_111_000.lin",
				"nonstop_01_005.dat",
				"e01_112_000.lin",
				"e01_113_000.lin",
				"e01_153_000.lin",
				"nonstop_01_006.dat",
				"e01_114_000.lin",
				"e01_115_000.lin",
				"nonstop_01_007.dat",
				"e01_116_000.lin",
				"e01_117_000.lin",
				"nonstop_01_008.dat",
				"e01_118_000.lin",
				"e01_119_000.lin",
				"e01_156_000.lin",
				"e01_120_000.lin",
				"e01_121_000.lin",
				"e01_155_000.lin",
				"e01_122_000.lin",
				"hs_mtb_s01.pak",
				"e01_123_000.lin",
				"e01_200_000.lin",
				"e01_201_000.lin",
				"e01_198_000.lin",
				"e01_199_000.lin",
				"e01_196_000.lin",
				"e01_197_000.lin"));

		//Chapter 2
		map.put(Chapter.CHAPTER2_EL, Arrays.asList("e02_001_103.lin",
				"e02_001_105.lin",
				"e02_002_135.lin",
				"e02_003_006.lin",
				"e02_004_006.lin",
				"e02_004_004.lin",
				"e02_004_001.lin",
				"e02_004_021.lin",
				"e02_004_031.lin",
				"e02_004_032.lin",
				"e02_005_022.lin",
				"e02_006_026.lin",
				"e02_006_027.lin",
				"e02_006_030.lin",
				"e02_007_135.lin",
				"e02_008_103.lin",
				"e02_008_101.lin",
				"e02_009_135.lin",
				"e02_009_001.lin",
				"e02_009_021.lin",
				"e02_009_026.lin",
				"e02_009_101.lin",
				"e02_009_136.lin",
				"e02_009_140.lin",
				"e02_009_141.lin",
				"e02_009_146.lin",
				"e02_010_022.lin",
				"e02_011_103.lin",
				"e02_011_001.lin",
				"e02_011_021.lin",
				"e02_011_022.lin",
				"e02_011_101.lin",
				"e02_013_103.lin",
				"e02_013_101.lin",
				"e02_013_135.lin",
				"e02_014_103.lin",
				"e02_016_101.lin",
				"e02_016_103.lin",
				"e02_017_135.lin",
				"e02_017_144.lin",
				"e02_018_103.lin",
				"e02_018_135.lin",
				"e02_019_103.lin",
				"e02_020_022.lin",
				"e02_020_021.lin",
				"e02_021_103.lin",
				"e02_022_103.lin",
				"e02_022_101.lin",
				"e02_022_001.lin",
				"e02_022_003.lin",
				"e02_022_010.lin",
				"e02_022_004.lin",
				"e02_023_006.lin",
				"e02_024_103.lin",
				"e02_024_101.lin",
				"e02_025_135.lin",
				"e02_025_001.lin",
				"e02_025_021.lin",
				"e02_025_022.lin",
				"e02_025_101.lin",
				"e02_025_137.lin",
				"e02_026_026.lin",

				//Generic Text
				"e02_000_003.lin",
				"e02_000_004.lin",
				"e02_000_006.lin",
				"e02_000_009.lin",
				"e02_000_010.lin",
				"e02_000_014.lin",
				"e02_000_015.lin",
				"e02_000_016.lin",
				"e02_000_022.lin",
				"e02_000_026.lin",
				"e02_000_030.lin",
				"e02_000_031.lin",
				"e02_000_032.lin",
				"e02_000_033.lin",
				"e02_000_037.lin",
				"e02_000_103.lin",
				"e02_000_135.lin",
				"e02_000_136.lin",
				"e02_000_137.lin",
				"e02_000_139.lin",
				"e02_000_140.lin",
				"e02_000_141.lin",
				"e02_000_144.lin",
				"e02_000_145.lin",
				"e02_000_146.lin",
				"script_pak_e02_0000.lin",
				"script_pak_e02_0004.lin",
				"script_pak_e02_0005.lin",
				"script_pak_e02_0006.lin",
				"script_pak_e02_0007.lin",
				"script_pak_e02_0008.lin",
				"script_pak_e02_0009.lin",
				"script_pak_e02_0010.lin",
				"script_pak_e02_0011.lin",
				"script_pak_e02_0013.lin",
				"script_pak_e02_0014.lin",
				"script_pak_e02_0015.lin",
				"script_pak_e02_0016.lin",
				"script_pak_e02_0017.lin",
				"script_pak_e02_0018.lin",
				"script_pak_e02_0019.lin",
				"script_pak_e02_0021.lin",
				"script_pak_e02_0023.lin",
				"script_pak_e02_0024.lin",
				"script_pak_e02_0025.lin",
				"script_pak_e02_0026.lin",
				"script_pak_e02_0027.lin",
				"script_pak_e02_0028.lin",
				"script_pak_e02_0029.lin",
				"script_pak_e02_0030.lin",
				"script_pak_e02_0031.lin"
				));
		map.put(Chapter.CHAPTER2_NL, Arrays.asList("e02_027_029.lin",
				"e02_028_026.lin",
				"e02_028_003.lin",
				"e02_029_101.lin",
				"e02_030_021.lin",
				"e02_030_022.lin",
				"e02_030_025.lin",
				"e02_032_021.lin",
				"e02_032_022.lin",
				"e02_032_025.lin",
				"e02_032_026.lin",
				"e02_032_027.lin",
				"e02_032_029.lin",
				"e02_032_135.lin",
				"e02_032_140.lin",
				"e02_032_001.lin",
				"e02_032_003.lin",
				"e02_032_004.lin",
				"e02_032_006.lin",
				"e02_032_009.lin",
				"e02_032_010.lin",
				"e02_032_014.lin",
				"e02_032_015.lin",
				"e02_032_016.lin",
				"e02_032_030.lin",
				"e02_032_031.lin",
				"e02_032_032.lin",
				"e02_032_033.lin",
				"e02_032_101.lin",
				"e02_032_136.lin",
				"e02_032_137.lin",
				"e02_032_139.lin",
				"e02_032_141.lin",
				"e02_032_144.lin",
				"e02_032_145.lin",
				"e02_032_146.lin",
				"e02_255_006.lin",
				"e02_033_001.lin",
				"e02_033_201.lin",
				"e02_033_204.lin"));
		map.put(Chapter.CHAPTER2_TRIAL, Arrays.asList("e02_101_000.lin",
				"nonstop_02_001.dat",
				"e02_102_000.lin",
				"e02_103_000.lin",
				"e02_150_000.lin",
				"nonstop_02_002.dat",
				"e02_104_000.lin",
				"e02_105_000.lin",
				"e02_106_000.lin",
				"anagram_21.dat",
				"e02_107_000.lin",
				"nonstop_02_003.dat",
				"e02_108_000.lin",
				"e02_109_000.lin",
				"e02_151_000.lin",
				"nonstop_02_004.dat",
				"e02_110_000.lin",
				"e02_111_000.lin",
				"nonstop_02_005.dat",
				"e02_112_000.lin",
				"e02_113_000.lin",
				"nonstop_02_006.dat",
				"e02_114_000.lin",
				"e02_115_000.lin",
				"e02_116_000.lin",
				"e02_117_000.lin",
				"nonstop_02_007.dat",
				"e02_118_000.lin",
				"e02_119_000.lin",
				"nonstop_02_008.dat",
				"e02_120_000.lin",
				"e02_121_000.lin",
				"nonstop_02_009.dat",
				"e02_122_000.lin",
				"e02_123_000.lin",
				"e02_124_000.lin",
				"e02_125_000.lin",
				"e02_152_000.lin",
				"hs_mtb_s02.pak",
				"e02_127_000.lin",
				"e02_200_000.lin",
				"e02_201_000.lin",
				"e02_198_000.lin",
				"e02_199_000.lin",
				"e02_196_000.lin",
				"e02_197_000.lin"));

		map.put(Chapter.CHAPTER3_EL, Arrays.asList("e03_001_123.lin",
				"e03_002_135.lin",
				"e03_003_021.lin",
				"e03_003_027.lin",
				"e03_003_041.lin",
				"e03_003_051.lin",
				"e03_003_052.lin",
				"e03_003_001.lin",
				"e03_003_003.lin",
				"e03_003_101.lin",
				"e03_003_135.lin",
				"e03_003_136.lin",
				"e03_003_141.lin",
				"e03_004_042.lin",
				"e03_005_044.lin",
				"e03_005_046.lin",
				"e03_006_047.lin",
				"e03_006_048.lin",
				"e03_255_003.lin",
				"e03_007_135.lin",
				"e03_255_004.lin",
				"e03_007_141.lin",
				"e03_007_142.lin",
				"e03_008_101.lin",
				"e03_008_141.lin",
				"e03_008_135.lin",
				"e03_009_006.lin",
				"e03_010_103.lin",
				"e03_010_101.lin",
				"e03_011_135.lin",
				"e03_012_103.lin",
				"e03_012_001.lin",
				"e03_012_021.lin",
				"e03_012_041.lin",
				"e03_012_101.lin",
				"e03_012_136.lin",
				"e03_013_103.lin",
				"e03_013_101.lin",
				"e03_014_142.lin",
				"e03_015_103.lin",
				"e03_015_101.lin",
				"e03_016_135.lin",
				"e03_016_141.lin",
				"e03_017_103.lin",
				"e03_017_001.lin",
				"e03_017_021.lin",
				"e03_017_041.lin",
				"e03_017_101.lin",
				"e03_017_136.lin",
				"e03_018_103.lin",
				"e03_018_001.lin",
				"e03_018_021.lin",
				"e03_018_041.lin",
				"e03_018_101.lin",
				"e03_018_136.lin",
				"e03_019_103.lin",
				"e03_019_101.lin",
				"e03_020_135.lin",
				"e03_021_103.lin",
				"e03_021_001.lin",
				"e03_021_021.lin",
				"e03_021_041.lin",
				"e03_021_101.lin",
				"e03_021_136.lin",
				"e03_022_103.lin",
				"e03_022_001.lin",
				"e03_022_021.lin",
				"e03_022_041.lin",
				"e03_022_101.lin",
				"e03_022_136.lin",
				"e03_023_103.lin",
				"e03_023_101.lin",
				"e03_024_135.lin",
				"e03_024_141.lin",
				"e03_025_103.lin",
				"e03_025_135.lin",
				"e03_025_101.lin",
				"e03_026_001.lin",
				"e03_026_003.lin",
				"e03_026_009.lin",
				"e03_026_010.lin",
				"e03_026_011.lin",
				"e03_026_014.lin",
				"e03_026_015.lin",
				"e03_026_016.lin",
				"e03_027_041.lin",
				"e03_028_042.lin",
				"e03_029_021.lin",
				"e03_030_022.lin",
				"e03_030_011.lin",
				"e03_031_001.lin",
				"e03_031_021.lin",
				"e03_031_022.lin",
				"e03_032_041.lin",
				"e03_033_001.lin",
				"e03_034_011.lin",
				"e03_035_001.lin",
				"e03_035_041.lin",
				"e03_035_042.lin",
				"e03_036_047.lin",

				//Generic text
				"e03_000_003.lin",
				"e03_000_004.lin",
				"e03_000_005.lin",
				"e03_000_006.lin",
				"e03_000_009.lin",
				"e03_000_010.lin",
				"e03_000_011.lin",
				"e03_000_014.lin",
				"e03_000_015.lin",
				"e03_000_016.lin",
				"e03_000_022.lin",
				"e03_000_025.lin",
				"e03_000_026.lin",
				"e03_000_030.lin",
				"e03_000_031.lin",
				"e03_000_032.lin",
				"e03_000_033.lin",
				"e03_000_037.lin",
				"e03_000_042.lin",
				"e03_000_044.lin",
				"e03_000_046.lin",
				"e03_000_047.lin",
				"e03_000_048.lin",
				"e03_000_051.lin",
				"e03_000_052.lin",
				"e03_000_135.lin",
				"e03_000_136.lin",
				"e03_000_137.lin",
				"e03_000_139.lin",
				"e03_000_140.lin",
				"e03_000_141.lin",
				"e03_000_144.lin",
				"e03_000_145.lin",
				"e03_000_146.lin",
				"script_pak_e03_0000.lin",
				"script_pak_e03_0004.lin",
				"script_pak_e03_0005.lin",
				"script_pak_e03_0006.lin",
				"script_pak_e03_0007.lin",
				"script_pak_e03_0008.lin",
				"script_pak_e03_0009.lin",
				"script_pak_e03_0010.lin",
				"script_pak_e03_0012.lin",
				"script_pak_e03_0013.lin",
				"script_pak_e03_0014.lin",
				"script_pak_e03_0016.lin",
				"script_pak_e03_0017.lin",
				"script_pak_e03_0018.lin",
				"script_pak_e03_0019.lin",
				"script_pak_e03_0020.lin",
				"script_pak_e03_0021.lin",
				"script_pak_e03_0022.lin",
				"script_pak_e03_0023.lin",
				"script_pak_e03_0025.lin",
				"script_pak_e03_0026.lin",
				"script_pak_e03_0027.lin",
				"script_pak_e03_0028.lin",
				"script_pak_e03_0029.lin",
				"script_pak_e03_0031.lin",
				"script_pak_e03_0032.lin",
				"script_pak_e03_0036.lin",
				"script_pak_e03_0037.lin",
				"script_pak_e03_0038.lin",
				"script_pak_e03_0039.lin",
				"script_pak_e03_0040.lin",
				"script_pak_e03_0041.lin",
				"script_pak_e03_0043.lin",
				"script_pak_e03_0044.lin",
				"script_pak_e03_0045.lin"));
		map.put(Chapter.CHAPTER3_NL, Arrays.asList("e03_037_048.lin",
				"e03_037_041.lin",
				"e03_037_011.lin",
				"e03_034_048.lin",
				"e03_038_042.lin",
				"e03_038_044.lin",
				"e03_038_047.lin",
				"e03_038_048.lin",
				"e03_038_051.lin",
				"e03_038_052.lin",
				"e03_038_041.lin",
				"e03_039_044.lin",
				"e03_039_046.lin",
				"e03_040_046.lin",
				"e03_255_006.lin",
				"e03_040_011.lin",
				"e03_040_044.lin",
				"e03_040_048.lin",
				"e03_040_001.lin",
				"e03_040_003.lin",
				"e03_040_004.lin",
				"e03_040_005.lin",
				"e03_040_006.lin",
				"e03_040_009.lin",
				"e03_040_010.lin",
				"e03_040_014.lin",
				"e03_040_015.lin",
				"e03_040_016.lin",
				"e03_040_021.lin",
				"e03_040_022.lin",
				"e03_040_025.lin",
				"e03_040_026.lin",
				"e03_040_027.lin",
				"e03_040_030.lin",
				"e03_040_031.lin",
				"e03_040_032.lin",
				"e03_040_033.lin",
				"e03_040_041.lin",
				"e03_040_042.lin",
				"e03_040_047.lin",
				"e03_040_051.lin",
				"e03_040_052.lin",
				"e03_040_135.lin",
				"e03_040_136.lin",
				"e03_040_137.lin",
				"e03_040_139.lin",
				"e03_040_140.lin",
				"e03_040_141.lin",
				"e03_040_144.lin",
				"e03_040_145.lin",
				"e03_040_146.lin",
				"e03_255_005.lin",
				"e03_040_101.lin",
				"e03_042_117.lin",
				"e03_043_101.lin",
				"e03_044_030.lin",
				"e03_045_021.lin",
				"e03_045_041.lin",
				"e03_045_046.lin",
				"e03_046_001.lin",
				"e03_046_201.lin",
				"e03_046_205.lin"));
		map.put(Chapter.CHAPTER3_TRIAL, Arrays.asList("e03_101_000.lin",
				"nonstop_03_001.dat",
				"e03_102_000.lin",
				"e03_103_000.lin",
				"e03_150_000.lin",
				"hs_mtb_s03.pak",
				"e03_105_000.lin",
				"nonstop_03_002.dat",
				"e03_106_000.lin",
				"e03_107_000.lin",
				"nonstop_03_003.dat",
				"e03_108_000.lin",
				"e03_109_000.lin",
				"e03_110_000.lin",
				"anagram_31.dat",
				"e03_111_000.lin",
				"nonstop_03_004.dat",
				"e03_112_000.lin",
				"e03_113_000.lin",
				"nonstop_03_005.dat",
				"e03_114_000.lin",
				"e03_115_000.lin",
				"nonstop_03_006.dat",
				"e03_116_000.lin",
				"e03_117_000.lin",
				"nonstop_03_007.dat",
				"e03_118_000.lin",
				"e03_119_000.lin",
				"nonstop_03_008.dat",
				"e03_120_000.lin",
				"e03_121_000.lin",
				"nonstop_03_009.dat",
				"e03_122_000.lin",
				"e03_123_000.lin",
				"nonstop_03_010.dat",
				"e03_124_000.lin",
				"e03_125_000.lin",
				"nonstop_03_011.dat",
				"e03_126_000.lin",
				"e03_127_000.lin",
				"e03_128_000.lin",
				"e03_129_000.lin",
				"e03_200_205.lin",
				"e03_200_211.lin",
				"e03_198_000.lin",
				"e03_199_000.lin",
				"e03_196_000.lin",
				"e03_197_000.lin",

				//Post Trial
				"e03_201_101.lin",
				"e03_201_141.lin",
				"e03_202_021.lin",
				"e03_202_033.lin",
				"e03_202_035.lin",
				"e03_202_036.lin",
				"e03_203_001.lin",
				"e03_203_004.lin",
				"e03_203_006.lin"));

		map.put(Chapter.CHAPTER4_EL, Arrays.asList("e04_001_135.lin",
				"e04_002_135.lin",
				"e04_003_101.lin",
				"e04_003_061.lin",
				"e04_003_063.lin",
				"e04_003_065.lin",
				"e04_003_067.lin",
				"e04_003_070.lin",
				"e04_255_105.lin",
				"e04_004_135.lin",
				"e04_005_101.lin",
				"e04_005_141.lin",
				"e04_006_101.lin",
				"e04_006_103.lin",
				"e04_007_101.lin",
				"e04_007_135.lin",
				"e04_008_103.lin",
				"e04_009_103.lin",
				"e04_009_101.lin",
				"e04_009_001.lin",
				"e04_009_004.lin",
				"e04_009_006.lin",
				"e04_010_103.lin",
				"e04_010_101.lin",
				"e04_010_135.lin",
				"e04_011_103.lin",
				"e04_012_103.lin",
				"e04_013_101.lin",
				"e04_013_135.lin",
				"e04_013_011.lin",
				"e04_013_141.lin",
				"e04_255_015.lin",
				"e04_255_016.lin",
				"e04_014_101.lin",
				"e04_014_001.lin",
				"e04_014_021.lin",
				"e04_014_033.lin",
				"e04_014_036.lin",
				"e04_015_103.lin",
				"e04_015_041.lin",

				//Generic text
				"e04_000_003.lin",
				"e04_000_004.lin",
				"e04_000_005.lin",
				"e04_000_006.lin",
				"e04_000_009.lin",
				"e04_000_010.lin",
				"e04_000_011.lin",
				"e04_000_014.lin",
				"e04_000_015.lin",
				"e04_000_016.lin",
				"e04_000_022.lin",
				"e04_000_025.lin",
				"e04_000_026.lin",
				"e04_000_030.lin",
				"e04_000_031.lin",
				"e04_000_032.lin",
				"e04_000_033.lin",
				"e04_000_036.lin",
				"e04_000_037.lin",
				"e04_000_042.lin",
				"e04_000_043.lin",
				"e04_000_044.lin",
				"e04_000_046.lin",
				"e04_000_047.lin",
				"e04_000_048.lin",
				"e04_000_051.lin",
				"e04_000_052.lin",
				"e04_000_061.lin",
				"e04_000_063.lin",
				"e04_000_064.lin",
				"e04_000_065.lin",
				"e04_000_067.lin",
				"e04_000_070.lin",
				"e04_000_071.lin",
				"e04_000_072.lin",
				"e04_000_101.lin",
				"e04_000_103.lin",
				"e04_000_135.lin",
				"e04_000_136.lin",
				"e04_000_137.lin",
				"e04_000_139.lin",
				"e04_000_140.lin",
				"e04_000_141.lin",
				"e04_000_144.lin",
				"e04_000_145.lin",
				"e04_000_146.lin",
				"e04_255_000.lin",
				"e04_255_001.lin",
				"e04_255_002.lin",
				"e04_255_003.lin",
				"e04_255_004.lin",
				"e04_255_005.lin",
				"e04_255_006.lin",
				"e04_255_007.lin",
				"e04_255_008.lin",
				"e04_255_009.lin",
				"e04_255_010.lin",
				"e04_255_011.lin",
				"e04_255_012.lin",
				"e04_255_013.lin",
				"e04_255_014.lin",
				"e04_255_018.lin",
				"e04_255_019.lin",
				"e04_255_020.lin",
				"e04_255_021.lin",
				"e04_255_022.lin",
				"e04_255_023.lin",
				"e04_255_024.lin",
				"e04_255_025.lin",
				"e04_255_026.lin",
				"e04_255_027.lin",
				"e04_255_028.lin",
				"e04_255_029.lin",
				"e04_255_030.lin",
				"e04_255_031.lin",
				"e04_255_032.lin",
				"e04_255_033.lin",
				"e04_255_034.lin",
				"e04_255_035.lin",
				"e04_255_036.lin",
				"e04_255_037.lin",
				"e04_255_038.lin",
				"e04_255_039.lin",
				"e04_255_040.lin",
				"e04_255_041.lin",
				"e04_255_042.lin",
				"script_pak_e04_0000.lin",
				"script_pak_e04_0004.lin",
				"script_pak_e04_0005.lin",
				"script_pak_e04_0006.lin",
				"script_pak_e04_0007.lin",
				"script_pak_e04_0008.lin",
				"script_pak_e04_0009.lin",
				"script_pak_e04_0010.lin",
				"script_pak_e04_0011.lin",
				"script_pak_e04_0012.lin",
				"script_pak_e04_0013.lin",
				"script_pak_e04_0015.lin",
				"script_pak_e04_0016.lin",
				"script_pak_e04_0017.lin",
				"script_pak_e04_0018.lin",
				"script_pak_e04_0019.lin",
				"script_pak_e04_0020.lin",
				"script_pak_e04_0021.lin",
				"script_pak_e04_0022.lin",
				"script_pak_e04_0023.lin",
				"script_pak_e04_0025.lin",
				"script_pak_e04_0026.lin",
				"script_pak_e04_0027.lin",
				"script_pak_e04_0028.lin",
				"script_pak_e04_0029.lin",
				"script_pak_e04_0030.lin",
				"script_pak_e04_0031.lin",
				"script_pak_e04_0032.lin",
				"script_pak_e04_0033.lin",
				"script_pak_e04_0034.lin",
				"script_pak_e04_0035.lin",
				"script_pak_e04_0036.lin",
				"script_pak_e04_0037.lin",
				"script_pak_e04_0038.lin",
				"script_pak_e04_0039.lin",
				"script_pak_e04_0040.lin",
				"script_pak_e04_0041.lin",
				"script_pak_e04_0042.lin",
				"script_pak_e04_0043.lin",
				"script_pak_e04_0044.lin",
				"script_pak_e04_0045.lin",
				"script_pak_e04_0046.lin",
				"script_pak_e04_0047.lin",
				"script_pak_e04_0048.lin",
				"script_pak_e04_0050.lin",
				"script_pak_e04_0051.lin",
				"script_pak_e04_0052.lin"));
		map.put(Chapter.CHAPTER4_NL, Arrays.asList("e04_016_043.lin",
				"e04_017_043.lin",
				"e04_255_100.lin",
				"e04_255_101.lin",
				"e04_017_041.lin",
				"e04_017_101.lin",
				"e04_255_017.lin",
				"e04_255_106.lin",
				"e04_017_061.lin",
				"e04_017_141.lin",
				"e04_018_043.lin",
				"e04_255_102.lin",
				"e04_018_061.lin",
				"e04_018_063.lin",
				"e04_018_064.lin",
				"e04_255_103.lin",
				"e04_255_104.lin",
				"e04_255_107.lin",
				"e04_255_150.lin",
				"e04_019_201.lin",
				"e04_019_220.lin"));
		map.put(Chapter.CHAPTER4_TRIAL, Arrays.asList("e04_101_000.lin",
				"nonstop_04_001.dat",
				"e04_102_000.lin",
				"e04_103_000.lin",
				"nonstop_04_002.dat",
				"e04_104_000.lin",
				"e04_105_000.lin",
				"nonstop_04_003.dat",
				"e04_106_000.lin",
				"e04_107_000.lin",
				"hs_mtb_s04.pak",
				"e04_109_000.lin",
				"nonstop_04_004.dat",
				"e04_110_000.lin",
				"e04_111_000.lin",
				"e04_112_000.lin",
				"anagram_41.dat",
				"e04_113_000.lin",
				"e04_150_000.lin",
				"hs_mtb_s05.pak",
				"e04_115_000.lin",
				"nonstop_04_005.dat",
				"e04_116_000.lin",
				"e04_117_000.lin",
				"nonstop_04_006.dat",
				"e04_118_000.lin",
				"e04_119_000.lin",
				"e04_120_000.lin",
				"anagram_42.dat",
				"e04_121_000.lin",
				"nonstop_04_007.dat",
				"e04_122_000.lin",
				"e04_123_000.lin",
				"nonstop_04_008.dat",
				"e04_124_000.lin",
				"e04_125_000.lin",
				"hs_mtb_s06.pak",
				"e04_127_000.lin",
				"e04_128_000.lin",
				"e04_129_000.lin",
				"e04_200_206.lin",
				"e04_200_213.lin",
				"e04_198_000.lin",
				"e04_199_000.lin",
				"e04_195_000.lin",
				"e04_196_000.lin",
				"e04_197_000.lin",

				//Post trial
				"e04_201_103.lin",
				"e04_201_061.lin",
				"e04_201_101.lin"));

		map.put(Chapter.CHAPTER5_EL, Arrays.asList("e05_002_135.lin",
				"e05_003_101.lin",
				"e05_003_001.lin",
				"e05_003_021.lin",
				"e05_003_061.lin",
				"e05_003_081.lin",
				"e05_003_083.lin",
				"e05_003_085.lin",
				"e05_003_086.lin",
				"e05_003_087.lin",
				"e05_003_091.lin",
				"e05_003_092.lin",
				"e05_007_135.lin",
				"e05_008_103.lin",
				"e05_009_141.lin",
				"e05_010_101.lin",
				"e05_011_103.lin",
				"e05_011_101.lin",
				"e05_012_135.lin",
				"e05_013_001.lin",
				"e05_013_021.lin",
				"e05_013_061.lin",
				"e05_013_101.lin",
				"e05_014_001.lin",
				"e05_014_021.lin",
				"e05_014_061.lin",
				"e05_014_101.lin",
				"e05_013_103.lin",
				"e05_014_103.lin",
				"e05_015_103.lin",
				"e05_016_103.lin",
				"e05_016_101.lin",
				"e05_017_135.lin",
				"e05_017_101.lin",
				"e05_017_001.lin",
				"e05_017_004.lin",
				"e05_018_006.lin",
				"e05_019_061.lin",

				//Generic text
				"e05_000_001.lin",
				"e05_000_003.lin",
				"e05_000_004.lin",
				"e05_000_005.lin",
				"e05_000_006.lin",
				"e05_000_009.lin",
				"e05_000_010.lin",
				"e05_000_011.lin",
				"e05_000_014.lin",
				"e05_000_015.lin",
				"e05_000_016.lin",
				"e05_000_021.lin",
				"e05_000_022.lin",
				"e05_000_025.lin",
				"e05_000_026.lin",
				"e05_000_030.lin",
				"e05_000_031.lin",
				"e05_000_032.lin",
				"e05_000_033.lin",
				"e05_000_037.lin",
				"e05_000_042.lin",
				"e05_000_044.lin",
				"e05_000_046.lin",
				"e05_000_047.lin",
				"e05_000_048.lin",
				"e05_000_051.lin",
				"e05_000_052.lin",
				"e05_000_061.lin",
				"e05_000_063.lin",
				"e05_000_065.lin",
				"e05_000_066.lin",
				"e05_000_067.lin",
				"e05_000_068.lin",
				"e05_000_070.lin",
				"e05_000_071.lin",
				"e05_000_072.lin",
				"e05_000_083.lin",
				"e05_000_084.lin",
				"e05_000_085.lin",
				"e05_000_086.lin",
				"e05_000_087.lin",
				"e05_000_089.lin",
				"e05_000_090.lin",
				"e05_000_091.lin",
				"e05_000_092.lin",
				"e05_000_103.lin",
				"e05_000_135.lin",
				"e05_000_136.lin",
				"e05_000_137.lin",
				"e05_000_139.lin",
				"e05_000_140.lin",
				"e05_000_141.lin",
				"e05_000_144.lin",
				"e05_000_145.lin",
				"e05_000_146.lin",
				"e05_255_100.lin",
				"e05_255_101.lin",
				"e05_255_102.lin",
				"script_pak_e05_0000.lin",
				"script_pak_e05_0003.lin",
				"script_pak_e05_0004.lin",
				"script_pak_e05_0005.lin",
				"script_pak_e05_0006.lin",
				"script_pak_e05_0007.lin",
				"script_pak_e05_0008.lin",
				"script_pak_e05_0009.lin",
				"script_pak_e05_0010.lin",
				"script_pak_e05_0011.lin",
				"script_pak_e05_0012.lin",
				"script_pak_e05_0013.lin",
				"script_pak_e05_0014.lin",
				"script_pak_e05_0015.lin",
				"script_pak_e05_0016.lin",
				"script_pak_e05_0017.lin",
				"script_pak_e05_0018.lin",
				"script_pak_e05_0019.lin",
				"script_pak_e05_0020.lin",
				"script_pak_e05_0021.lin",
				"script_pak_e05_0022.lin",
				"script_pak_e05_0024.lin",
				"script_pak_e05_0025.lin",
				"script_pak_e05_0026.lin",
				"script_pak_e05_0027.lin",
				"script_pak_e05_0028.lin",
				"script_pak_e05_0029.lin",
				"script_pak_e05_0030.lin",
				"script_pak_e05_0031.lin",
				"script_pak_e05_0032.lin",
				"script_pak_e05_0033.lin",
				"script_pak_e05_0034.lin",
				"script_pak_e05_0035.lin",
				"script_pak_e05_0036.lin",
				"script_pak_e05_0037.lin",
				"script_pak_e05_0038.lin",
				"script_pak_e05_0039.lin",
				"script_pak_e05_0041.lin",
				"script_pak_e05_0042.lin",
				"script_pak_e05_0043.lin",
				"script_pak_e05_0044.lin",
				"script_pak_e05_0045.lin",
				"script_pak_e05_0046.lin",
				"script_pak_e05_0047.lin",
				"script_pak_e05_0048.lin",
				"script_pak_e05_0049.lin",
				"script_pak_e05_0051.lin",
				"script_pak_e05_0052.lin",
				"script_pak_e05_0053.lin",
				"script_pak_e05_0054.lin",
				"script_pak_e05_0055.lin",
				"script_pak_e05_0056.lin",
				"script_pak_e05_0057.lin",
				"script_pak_e05_0058.lin",
				"script_pak_e05_0059.lin",
				"script_pak_e05_0060.lin"));
		map.put(Chapter.CHAPTER5_NL, Arrays.asList("e05_020_083.lin",
				"e05_020_084.lin",
				"e05_022_081.lin",
				"e05_022_041.lin",
				"e05_022_021.lin",
				"e05_022_001.lin",
				"e05_022_101.lin",
				"e05_022_061.lin",
				"e05_023_083.lin",
				"e05_023_061.lin",
				"e05_024_068.lin",
				"e05_025_083.lin",
				"e05_025_084.lin",
				"e05_025_085.lin",
				"e05_255_000.lin",
				"e05_026_006.lin",
				"e05_026_001.lin",
				"e05_026_003.lin",
				"e05_026_009.lin",
				"e05_026_011.lin",
				"e05_026_021.lin",
				"e05_026_022.lin",
				"e05_026_025.lin",
				"e05_026_026.lin",
				"e05_026_030.lin",
				"e05_026_042.lin",
				"e05_026_044.lin",
				"e05_026_046.lin",
				"e05_026_048.lin",
				"e05_026_061.lin",
				"e05_026_063.lin",
				"e05_026_065.lin",
				"e05_026_067.lin",
				"e05_026_068.lin",
				"e05_026_081.lin",
				"e05_026_087.lin",
				"e05_026_092.lin",
				"e05_027_101.lin",
				"e05_027_121.lin",
				"e05_028_087.lin",
				"e05_029_025.lin",
				"e05_030_001.lin",
				"e05_030_201.lin",
				"e05_030_207.lin"));
		map.put(Chapter.CHAPTER5_TRIAL, Arrays.asList("e05_101_000.lin",
				"nonstop_05_001.dat",
				"e05_102_000.lin",
				"e05_103_000.lin",
				"nonstop_05_002.dat",
				"e05_104_000.lin",
				"e05_105_000.lin",
				"e05_106_000.lin",
				"anagram_51.dat",
				"e05_107_000.lin",
				"e05_109_000.lin",
				"nonstop_05_003.dat",
				"e05_110_000.lin",
				"e05_111_000.lin",
				"hs_mtb_s07.pak",
				"e05_113_000.lin",
				"nonstop_05_004.dat",
				"e05_114_000.lin",
				"e05_115_000.lin",
				"nonstop_05_005.dat",
				"e05_116_000.lin",
				"e05_117_000.lin",
				"nonstop_05_006.dat",
				"e05_118_000.lin",
				"e05_119_000.lin",
				"nonstop_05_007.dat",
				"e05_120_000.lin",
				"e05_121_000.lin",
				"nonstop_05_008.dat",
				"e05_122_000.lin",
				"e05_123_000.lin",
				"e05_124_000.lin",
				"e05_150_000.lin",
				"nonstop_05_009.dat",
				"e05_151_000.lin",
				"e05_152_000.lin",
				"e05_153_000.lin",
				"e05_154_000.lin",
				"e05_155_000.lin",
				"e05_200_207.lin",
				"e05_200_214.lin",
				"e05_198_000.lin",
				"e05_199_000.lin",
				"e05_195_000.lin",
				"e05_196_000.lin",
				"e05_197_000.lin",

				//Post trial
				"e05_201_216.lin"));

		map.put(Chapter.CHAPTER6_EL, Arrays.asList(
				//Generic text
				"e06_000_001.lin",
				"e06_000_003.lin",
				"e06_000_004.lin",
				"e06_000_005.lin",
				"e06_000_006.lin",
				"e06_000_009.lin",
				"e06_000_010.lin",
				"e06_000_011.lin",
				"e06_000_014.lin",
				"e06_000_015.lin",
				"e06_000_016.lin",
				"e06_000_021.lin",
				"e06_000_022.lin",
				"e06_000_025.lin",
				"e06_000_026.lin",
				"e06_000_030.lin",
				"e06_000_031.lin",
				"e06_000_032.lin",
				"e06_000_033.lin",
				"e06_000_037.lin",
				"e06_000_042.lin",
				"e06_000_044.lin",
				"e06_000_046.lin",
				"e06_000_047.lin",
				"e06_000_048.lin",
				"e06_000_051.lin",
				"e06_000_052.lin",
				"e06_000_061.lin",
				"e06_000_063.lin",
				"e06_000_065.lin",
				"e06_000_066.lin",
				"e06_000_067.lin",
				"e06_000_068.lin",
				"e06_000_069.lin",
				"e06_000_070.lin",
				"e06_000_071.lin",
				"e06_000_072.lin",
				"e06_000_083.lin",
				"e06_000_087.lin",
				"e06_000_089.lin",
				"e06_000_090.lin",
				"e06_000_091.lin",
				"e06_000_092.lin",
				"e06_000_101.lin",
				"e06_000_135.lin",
				"e06_000_136.lin",
				"e06_000_137.lin",
				"e06_000_139.lin",
				"e06_000_140.lin",
				"e06_000_141.lin",
				"e06_000_144.lin",
				"e06_000_145.lin",
				"e06_000_146.lin",
				"e06_000_148.lin",
				"e06_000_149.lin",
				"e06_000_150.lin",
				"e06_000_151.lin",
				"e06_000_152.lin",
				"e06_000_153.lin",
				"script_pak_e06_0000.lin",
				"script_pak_e06_0003.lin",
				"script_pak_e06_0004.lin",
				"script_pak_e06_0005.lin",
				"script_pak_e06_0006.lin",
				"script_pak_e06_0007.lin",
				"script_pak_e06_0008.lin",
				"script_pak_e06_0009.lin",
				"script_pak_e06_0010.lin",
				"script_pak_e06_0011.lin",
				"script_pak_e06_0012.lin",
				"script_pak_e06_0013.lin",
				"script_pak_e06_0014.lin",
				"script_pak_e06_0015.lin",
				"script_pak_e06_0016.lin",
				"script_pak_e06_0017.lin",
				"script_pak_e06_0018.lin",
				"script_pak_e06_0019.lin",
				"script_pak_e06_0020.lin",
				"script_pak_e06_0021.lin",
				"script_pak_e06_0022.lin",
				"script_pak_e06_0024.lin",
				"script_pak_e06_0025.lin",
				"script_pak_e06_0026.lin",
				"script_pak_e06_0027.lin",
				"script_pak_e06_0028.lin",
				"script_pak_e06_0029.lin",
				"script_pak_e06_0030.lin",
				"script_pak_e06_0031.lin",
				"script_pak_e06_0032.lin",
				"script_pak_e06_0033.lin",
				"script_pak_e06_0034.lin",
				"script_pak_e06_0035.lin",
				"script_pak_e06_0036.lin",
				"script_pak_e06_0037.lin",
				"script_pak_e06_0038.lin",
				"script_pak_e06_0039.lin",
				"script_pak_e06_0040.lin",
				"script_pak_e06_0042.lin",
				"script_pak_e06_0043.lin",
				"script_pak_e06_0044.lin",
				"script_pak_e06_0045.lin",
				"script_pak_e06_0046.lin",
				"script_pak_e06_0047.lin",
				"script_pak_e06_0048.lin",
				"script_pak_e06_0049.lin",
				"script_pak_e06_0050.lin",
				"script_pak_e06_0051.lin",
				"script_pak_e06_0052.lin",
				"script_pak_e06_0053.lin",
				"script_pak_e06_0054.lin",
				"script_pak_e06_0055.lin",
				"script_pak_e06_0056.lin",
				"script_pak_e06_0057.lin",
				"script_pak_e06_0058.lin",
				"script_pak_e06_0059.lin",
				"script_pak_e06_0060.lin",
				"script_pak_e06_0061.lin",
				"script_pak_e06_0062.lin",
				"script_pak_e06_0063.lin"
		));
		map.put(Chapter.CHAPTER6_NL, Arrays.asList("e06_001_216.lin",
				"e06_003_137.lin",
				"e06_003_101.lin",
				"e06_003_001.lin",
				"e06_003_004.lin",
				"e06_004_006.lin",
				"e06_005_004.lin",
				"e06_005_001.lin",
				"e06_005_101.lin",
				"e06_006_135.lin",
				"e06_007_001.lin",
				"e06_007_021.lin",
				"e06_007_135.lin",
				"e06_007_153.lin",
				"e06_007_066.lin",
				"e06_007_068.lin",
				"e06_007_069.lin",
				"e06_007_061.lin",
				"e06_007_083.lin",
				"e06_007_085.lin",
				"e06_007_087.lin",
				"e06_007_089.lin",
				"e06_007_101.lin",
				"e06_007_148.lin",
				"e06_007_151.lin",
				"e06_007_152.lin",
				"e06_007_150.lin",
				"e06_007_157.lin",
				"e06_007_158.lin",
				"e06_255_000.lin",
				"e06_015_004.lin",
				"e06_016_006.lin",
				"e06_017_004.lin",
				"e06_017_025.lin",
				"e06_017_083.lin",
				"e06_017_135.lin",
				"e06_018_089.lin",
				"e06_020_009.lin",
				"e06_021_001.lin",
				"e06_021_201.lin",
				"e06_021_208.lin"));
		map.put(Chapter.CHAPTER6_TRIAL, Arrays.asList("e06_101_000.lin",
				"nonstop_06_001.dat",
				"e06_102_000.lin",
				"e06_103_000.lin",
				"e06_104_000.lin",
				"anagram_61.dat",
				"e06_105_000.lin",
				"nonstop_06_002.dat",
				"e06_106_000.lin",
				"e06_107_000.lin",
				"nonstop_06_003.dat",
				"e06_108_000.lin",
				"e06_109_000.lin",
				"nonstop_06_004.dat",
				"e06_110_000.lin",
				"e06_111_000.lin",
				"nonstop_06_005.dat",
				"e06_112_000.lin",
				"e06_113_000.lin",
				"e06_114_000.lin",
				"hs_mtb_s08.pak",
				"e06_116_000.lin",
				"e06_117_000.lin",
				"nonstop_06_006.dat",
				"e06_118_000.lin",
				"e06_119_000.lin",
				"nonstop_06_007.dat",
				"e06_120_000.lin",
				"e06_121_000.lin",
				"e06_122_000.lin",
				"anagram_62.dat",
				"e06_123_000.lin",
				"e06_124_000.lin",
				"hs_mtb_s09.pak",
				"e06_126_000.lin",
				"e06_127_000.lin",
				"e06_128_000.lin",
				"e06_129_000.lin",
				"e06_130_000.lin",
				"e06_131_000.lin",
				"e06_132_000.lin",
				"e06_133_000.lin",
				"nonstop_06_008.dat",
				"e06_134_000.lin",
				"e06_135_000.lin",
				"e06_136_000.lin",
				"nonstop_06_009.dat",
				"e06_137_000.lin",
				"e06_138_000.lin",
				"e06_139_000.lin",
				"e06_140_000.lin",
				"e06_141_000.lin",
				"anagram_63.dat",
				"e06_142_000.lin",
				"nonstop_06_010.dat",
				"nonstop_06_025.dat",
				"e06_143_000.lin",
				"e06_144_000.lin",
				"hs_mtb_s10.pak",
				"e06_146_000.lin",
				"e06_200_208.lin",
				"e06_198_000.lin",
				"e06_199_000.lin",
				"e06_195_000.lin",
				"e06_196_000.lin",
				"e06_197_000.lin"
		));

		map.put(Chapter.EPILOGUE, Arrays.asList("e07_001_003.lin",
				"script_pak_e07_0000.lin"));

		map.put(Chapter.FTE, Arrays.asList(
				//Ishimaru
				"e08_001_001.lin",
				"e08_001_002.lin",
				"e08_001_003.lin",
				"e08_001_004.lin",
				"e08_001_005.lin",
				"e08_001_006.lin",
				"e08_001_007.lin",
				"e08_001_008.lin",
				"e08_001_009.lin",
				"e08_001_000.lin",
				"e08_001_017.lin",
				"e08_001_020.lin",
				"e08_001_021.lin",
				"e08_001_022.lin",
				"e08_001_023.lin",

				//Saiyan
				"e08_001_010.lin",
				"e08_001_011.lin",
				"e08_001_012.lin",
				"e08_001_013.lin",
				"e08_001_016.lin",
				"e08_001_024.lin",

				//Togami
				"e08_002_001.lin",
				"e08_002_002.lin",
				"e08_002_003.lin",
				"e08_002_004.lin",
				"e08_002_005.lin",
				"e08_002_006.lin",
				"e08_002_007.lin",
				"e08_002_008.lin",
				"e08_002_009.lin",
				"e08_002_010.lin",
				"e08_002_011.lin",
				"e08_002_012.lin",
				"e08_002_013.lin",
				"e08_002_014.lin",
				"e08_002_000.lin",
				"e08_002_020.lin",
				"e08_002_021.lin",
				"e08_002_022.lin",
				"e08_002_023.lin",
				"e08_002_024.lin",

				//Oowada
				"e08_003_001.lin",
				"e08_003_002.lin",
				"e08_003_003.lin",
				"e08_003_004.lin",
				"e08_003_005.lin",
				"e08_003_006.lin",
				"e08_003_000.lin",
				"e08_003_020.lin",
				"e08_003_021.lin",
				"e08_003_022.lin",
				"e08_003_023.lin",

				//Kuwata
				"e08_004_001.lin",
				"e08_004_002.lin",
				"e08_004_003.lin",
				"e08_004_000.lin",
				"e08_004_020.lin",
				"e08_004_021.lin",
				"e08_004_022.lin",

				//Yamada
				"e08_005_001.lin",
				"e08_005_002.lin",
				"e08_005_003.lin",
				"e08_005_004.lin",
				"e08_005_005.lin",
				"e08_005_006.lin",
				"e08_005_007.lin",
				"e08_005_000.lin",
				"e08_005_020.lin",
				"e08_005_021.lin",
				"e08_005_022.lin",
				"e08_005_023.lin",
				"e08_005_024.lin",

				//Hagakure
				"e08_006_001.lin",
				"e08_006_002.lin",
				"e08_006_003.lin",
				"e08_006_004.lin",
				"e08_006_005.lin",
				"e08_006_006.lin",
				"e08_006_007.lin",
				"e08_006_008.lin",
				"e08_006_009.lin",
				"e08_006_010.lin",
				"e08_006_000.lin",
				"e08_006_020.lin",
				"e08_006_021.lin",
				"e08_006_022.lin",
				"e08_006_023.lin",
				"e08_006_024.lin",
				"e08_006_025.lin",

				//Maizono
				"e08_007_001.lin",
				"e08_007_002.lin",
				"e08_007_003.lin",
				"e08_007_000.lin",
				"e08_007_020.lin",
				"e08_007_021.lin",

				//Kirigiri
				"e08_008_001.lin",
				"e08_008_002.lin",
				"e08_008_003.lin",
				"e08_008_004.lin",
				"e08_008_005.lin",
				"e08_008_006.lin",
				"e08_008_007.lin",
				"e08_008_008.lin",
				"e08_008_000.lin",
				"e08_008_020.lin",
				"e08_008_021.lin",
				"e08_008_022.lin",
				"e08_008_023.lin",

				//Asahina
				"e08_009_001.lin",
				"e08_009_002.lin",
				"e08_009_003.lin",
				"e08_009_004.lin",
				"e08_009_005.lin",
				"e08_009_006.lin",
				"e08_009_007.lin",
				"e08_009_008.lin",
				"e08_009_009.lin",
				"e08_009_000.lin",
				"e08_009_016.lin",
				"e08_009_020.lin",
				"e08_009_021.lin",
				"e08_009_022.lin",
				"e08_009_023.lin",
				"e08_009_024.lin",
				"e08_009_025.lin",


				//Fukawa
				"e08_010_001.lin",
				"e08_010_002.lin",
				"e08_010_003.lin",
				"e08_010_004.lin",
				"e08_010_005.lin",
				"e08_010_006.lin",
				"e08_010_000.lin",
				"e08_010_020.lin",
				"e08_010_021.lin",
				"e08_010_022.lin",
				"e08_010_023.lin",
				"e08_010_024.lin",

				//Genocider
				"e08_010_007.lin",
				"e08_010_008.lin",
				"e08_010_009.lin",
				"e08_010_010.lin",
				"e08_010_016.lin",
				"e08_010_025.lin",
				"e08_010_026.lin",
				"e08_010_027.lin",

				//Oogami
				"e08_011_001.lin",
				"e08_011_002.lin",
				"e08_011_003.lin",
				"e08_011_004.lin",
				"e08_011_005.lin",
				"e08_011_006.lin",
				"e08_011_007.lin",
				"e08_011_008.lin",
				"e08_011_009.lin",
				"e08_011_010.lin",
				"e08_011_000.lin",
				"e08_011_016.lin",
				"e08_011_020.lin",
				"e08_011_021.lin",
				"e08_011_022.lin",
				"e08_011_023.lin",
				"e08_011_024.lin",

				//Celes
				"e08_012_001.lin",
				"e08_012_002.lin",
				"e08_012_003.lin",
				"e08_012_004.lin",
				"e08_012_005.lin",
				"e08_012_006.lin",
				"e08_012_000.lin",
				"e08_012_020.lin",
				"e08_012_021.lin",
				"e08_012_022.lin",
				"e08_012_023.lin",
				"e08_012_024.lin",
				"e08_012_025.lin",

				//Enoshima
				"e08_013_001.lin",
				"e08_013_002.lin",
				"e08_013_003.lin",
				"e08_013_004.lin",
				"e08_013_000.lin",
				"e08_013_020.lin",
				"e08_013_021.lin",
				"e08_013_022.lin",

				//Fujisaki
				"e08_014_001.lin",
				"e08_014_002.lin",
				"e08_014_003.lin",
				"e08_014_004.lin",
				"e08_014_005.lin",
				"e08_014_006.lin",
				"e08_014_007.lin",
				"e08_014_000.lin",
				"e08_014_016.lin",
				"e08_014_020.lin",
				"e08_014_021.lin",
				"e08_014_022.lin",
				"e08_014_023.lin"
				));
	}

	public Chapter get(String filename)
	{
		for (List<String> list: map.values()
			 )
		{
			if (list.contains(filename))
			{
				return getKeyByValue(map, list);
			}
		}
		return Chapter.UNKNOWN;
	}

public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
	for (Map.Entry<T, E> entry : map.entrySet()) {
		if (Objects.equals(value, entry.getValue())) {
			return entry.getKey();
		}
	}
	return null;
}
}
