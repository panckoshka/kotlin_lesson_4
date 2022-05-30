package wallPost.attachment

import wallPost.attachment.Attachment

class AppAttachment(
    val id: Int,
    val name: String,
    val photo130: String
) : Attachment() {
    override val type: String
        get() = "app"
}