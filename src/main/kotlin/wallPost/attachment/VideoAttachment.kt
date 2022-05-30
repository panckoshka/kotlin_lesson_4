package wallPost.attachment

class VideoAttachment(val video: Video) : Attachment() {
    override val type: String
        get() = "video"

    data class Video(val id: Int, val title: String) {

    }
}