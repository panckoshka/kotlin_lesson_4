package wallPost

import wallPost.attachment.Attachment

data class OriginalPost(
    val id: Int = 0,
    var ownerId: Int,
    var text: String?,
    val date: Int = 0,

    val attachments : MutableList<Attachment> = mutableListOf()
//    val fromId: Int,
//    val createdBy: Int,
//    val replyOwnerId: Int,
//    val replyPostId: Int,
//    val friendsOnly: Int = 1,
//    val comment: Int,
//    val rePosts: Boolean,
//    val postType: Boolean,
//    val signerId: Int,
//    val canPin: Boolean,
//    val canDelete: Boolean,
//    val canEdit: Boolean,
//    val isPinned: Boolean,
//    val markedAsAds: Boolean,
//    val isFavorite: Boolean
)