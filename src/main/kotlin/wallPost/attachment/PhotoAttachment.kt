package wallPost.attachment

class PhotoAttachment(val photo: Photo) : Attachment() {
    override val type: String
        get() = "photo"

}