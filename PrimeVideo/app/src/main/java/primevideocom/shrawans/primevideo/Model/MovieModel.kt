package primevideocom.shrawans.primevideo.Model

enum class SectionType {
    NoHeaderOfSection, MovieMaxCellWidth, MovieMinCellWidth
}


class MovieModel(var id: String ,var name:String ,var url:String = picURL) {
    companion object {
        var picURL = "https://i.imgur.com/tGbaZCY.jpg"
    }
}

//sectionType Decide Type of section we are going to layout
//HeaderString is optional
class  SectionModel(var sectionType: SectionType, var headerTitle:String = "Optional", var  sectionlist:Array<MovieModel> )
