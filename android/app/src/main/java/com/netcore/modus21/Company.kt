package com.netcore.modus21

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Autorenew
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.Layers
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material.icons.filled.DirectionsBoat
import androidx.compose.material.icons.filled.Public
import androidx.compose.ui.graphics.vector.ImageVector

data class CompanyValue(val name: String, val detail: String)

data class Capability(val name: String, val summary: String, val icon: ImageVector)

data class Partnership(val name: String, val icon: ImageVector)

data class Fact(val label: String, val value: String)

object Company {
    const val name = "Modus21"
    const val kicker = "Defense Technology Solutions"
    const val tagline = "Delivering Technology Solutions for Mission Success"
    const val hero = "Since 2004, Modus21 has provided reliable, high-quality technology services to the U.S. Department of War and our nation's warfighters."
    const val aboutTitle = "Two Decades of Mission-Focused Excellence"
    val about = listOf(
        "Modus21 is a small business based in Charleston, South Carolina. For over twenty years, we have supported critical defense missions through specialized expertise in Agile Software Development, Cloud Computing, Artificial Intelligence, Systems Integration, Model Based Systems Engineering, Business Process Re-engineering, Cybersecurity, and DevSecOps.",
        "We combine deep domain knowledge with disciplined execution to help our customers solve complex technical challenges in secure environments."
    )
    const val valuesIntro = "These values drive all of our decisions and activities. They keep us focused on disciplined execution, trusted partnerships, and dedication to the mission."
    const val capabilitiesIntro = "We deliver end-to-end technology solutions tailored to the unique demands of defense and national security environments."
    const val experienceTitle = "A Proven Partner to Defense Leaders"
    val experience = listOf(
        "Modus21 is a trusted partner to the Department of War and leading defense contractors. Our team maintains the highest standards of performance and compliance.",
        "We are proud to support programs at NIWC Atlantic and other critical naval and joint initiatives."
    )
    const val cultureTitle = "Culture"
    const val culture = "Our leadership is committed to maintaining a company that fosters innovation, professionalism, and an entrepreneurial spirit. Modus21 provides an open forum for communication and collaboration. We believe that our success is achieved through teamwork and that every employee's opinion is invaluable. We maintain an environment that rewards our employees for their performance and contributions to the success of our clients. Our team members are encouraged to participate in wellness initiatives and various company-sponsored functions throughout the year."
    const val careersPrompt = "If you would like more information on joining the Modus21 team, please contact us at careers@modus21.com."
    const val equalOpportunity = "Modus21 is an Equal Opportunity Employer. It is our policy to provide equal opportunity to all employees and applicants and to prohibit any discrimination because of race, color, religion, sex, national origin, age, marital status, genetic information, disability or protected veteran status."
    const val contactPrompt = "Ready to discuss how Modus21 can support your mission?"
    const val linkedInNote = "To contact us, please reach out through our LinkedIn company page."
    const val footer = "Delivering technology solutions for mission success since 2004."

    const val phoneDisplay = "(843) 958-8900"
    const val phoneUri = "tel:8439588900"
    const val careersEmail = "careers@modus21.com"
    const val careersMail = "mailto:careers@modus21.com"
    const val linkedIn = "https://www.linkedin.com/company/modus21-llc-"
    const val website = "https://www.modus21.com/"
    const val jobs = "https://modus21.hua.hrsmart.com/hr/ats/JobSearch/viewAll"
    const val privacyUrl = "https://www.modus21.com/privacy-policy"
    const val accessibilityUrl = "https://www.modus21.com/accessibility"

    const val street = "1362 McMillan Avenue"
    const val suite = "Suite 100"
    const val cityLine = "North Charleston, SC 29405"
    const val region = "Charleston, South Carolina"
    const val latitude = 32.8633169
    const val longitude = -79.9693698
    const val mapEmbed =
        "https://www.openstreetmap.org/export/embed.html?bbox=-79.99937%2C32.84832%2C-79.93937%2C32.87832&layer=mapnik&marker=32.8633169%2C-79.9693698"

    val facts = listOf(
        Fact("Founded", "2004"),
        Fact("Location", "Charleston, South Carolina"),
        Fact("Business Type", "Small Business"),
        Fact("Contracts", "Active on Multiple Prime Contracts")
    )

    val values = listOf(
        CompanyValue("Integrity", "We act with honesty, accountability, and respect in every decision."),
        CompanyValue("Quality", "We hold our work to high standards because mission outcomes depend on it."),
        CompanyValue("Value", "We focus our effort where it creates meaningful results for customers and warfighters.")
    )

    val capabilities = listOf(
        Capability("Agile Software Development", "Iterative delivery practices that keep mission software aligned with evolving operational needs.", Icons.Filled.Autorenew),
        Capability("Cloud Computing", "Secure cloud migration, data center modernization, and hybrid cloud solutions.", Icons.Filled.Cloud),
        Capability("Artificial Intelligence", "Applied AI solutions that help teams extract insights and improve decision-making.", Icons.Filled.AutoAwesome),
        Capability("Systems Integration", "Integrated systems planning and implementation for complex mission environments.", Icons.Filled.Link),
        Capability("Model Based Systems Engineering", "SysML-based modeling and digital thread practices that connect requirements, design, and verification across complex defense systems.", Icons.Filled.Layers),
        Capability("Business Process Re-engineering", "Process analysis and redesign that improves efficiency, quality, and mission outcomes.", Icons.Filled.SwapHoriz),
        Capability("Cybersecurity", "Risk management, compliance, and resilient system security.", Icons.Filled.Shield),
        Capability("DevSecOps", "Security engineered into automated development and deployment pipelines to deliver resilient software at mission speed.", Icons.Filled.Settings)
    )

    val partnerships = listOf(
        Partnership("Department of War partner", Icons.Filled.Flag),
        Partnership("Prime contractor relationships", Icons.Filled.Groups),
        Partnership("Highest standards of compliance", Icons.Filled.Verified),
        Partnership("NIWC Atlantic program support", Icons.Filled.DirectionsBoat),
        Partnership("Naval and joint initiative expertise", Icons.Filled.Public)
    )

    val benefits = listOf(
        "Competitive wage package and discretionary bonus pool",
        "Company-paid Medical Insurance Plan",
        "Company-paid Short and Long Term Disability",
        "Company-paid Dental, Vision, and Life Insurance",
        "401(k) plan with employer matching contribution",
        "Paid time off and holidays",
        "Tuition reimbursement",
        "Employee Assistance Program",
        "Monthly Corporate Wellness Benefit"
    )
}
