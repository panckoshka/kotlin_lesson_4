package wallPost.attachment

class PageAttachment(val page: Page) : Attachment() {
    override val type: String
        get() = "page"
}