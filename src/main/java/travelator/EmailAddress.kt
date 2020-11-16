package travelator

data class EmailAddress(
    val localPart: String,
    val domain: String
) {

    override fun toString() = "$localPart@$domain"

    companion object {
        @JvmStatic
        fun parse(value: String): EmailAddress {
            val atIndex = value.lastIndexOf('@')
            require(!(atIndex < 1 || atIndex == value.length - 1)) {
                "EmailAddress must be two parts separated by @"
            }
            val leftPart = value.substring(0, atIndex)
            val rightPart = value.substring(atIndex + 1)
            return EmailAddress(
                leftPart,
                rightPart
            )
        }
    }
}