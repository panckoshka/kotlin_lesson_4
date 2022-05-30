package wallPost.attachment

class AlbumAttachment(val album: Album) : Attachment() {
    override val type: String
        get() = "album"
}