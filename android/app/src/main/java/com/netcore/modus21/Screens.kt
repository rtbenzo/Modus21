@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)

package com.netcore.modus21

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.NorthEast
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.net.toUri
import java.util.Locale

@Composable
private fun AppScreen(
    title: String,
    largeTitle: Boolean = true,
    spacing: androidx.compose.ui.unit.Dp = 16.dp,
    onBack: (() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    val barColors = TopAppBarDefaults.topAppBarColors(
        containerColor = Brand.canvas,
        titleContentColor = Brand.ink,
        navigationIconContentColor = Brand.navy
    )
    Column(
        Modifier
            .fillMaxSize()
            .background(Brand.canvas)
    ) {
        if (largeTitle) {
            LargeTopAppBar(
                title = { Text(title) },
                windowInsets = WindowInsets(0),
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = Brand.canvas,
                    scrolledContainerColor = Color.White,
                    titleContentColor = Brand.ink
                )
            )
        } else {
            TopAppBar(
                title = { Text(title, maxLines = 1, overflow = TextOverflow.Ellipsis) },
                navigationIcon = {
                    if (onBack != null) {
                        IconButton(onClick = onBack) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                        }
                    }
                },
                windowInsets = WindowInsets(0),
                colors = barColors
            )
        }
        Column(
            Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(spacing),
            content = content
        )
    }
}

@Composable
private fun FilledAction(title: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 52.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Brand.navy, contentColor = Color.White)
    ) {
        Text(title, fontWeight = FontWeight.SemiBold, fontSize = 16.sp, textAlign = TextAlign.Center)
    }
}

@Composable
private fun OutlineAction(title: String, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 52.dp),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.5.dp, Brand.navy),
        colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.White, contentColor = Brand.navy)
    ) {
        Text(title, fontWeight = FontWeight.SemiBold, fontSize = 16.sp, textAlign = TextAlign.Center)
    }
}

@Composable
private fun BodyText(text: String, color: Color = Brand.muted) {
    Text(text, color = color, fontSize = 16.sp, lineHeight = 22.sp)
}

@Composable
private fun SectionTitle(text: String) {
    Text(text, color = Brand.ink, fontSize = 20.sp, fontWeight = FontWeight.Bold, lineHeight = 26.sp)
}

@Composable
fun MissionScreen(onCapabilities: () -> Unit, onContact: () -> Unit) {
    AppScreen(title = "Mission", spacing = 22.dp) {
        BrandCard {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Eyebrow(Company.region)
                Image(
                    painterResource(R.drawable.wordmark),
                    contentDescription = "Modus21",
                    modifier = Modifier.width(240.dp),
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.CenterStart
                )
                Text(Company.tagline, color = Brand.ink, fontSize = 22.sp, fontWeight = FontWeight.Bold, lineHeight = 28.sp)
                BodyText(Company.hero)
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    FilledAction("Learn About Our Capabilities", onCapabilities)
                    OutlineAction("Contact Us", onContact)
                }
            }
        }
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Eyebrow("About Us")
            SectionTitle(Company.aboutTitle)
            Company.about.forEach { BodyText(it) }
        }
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Company.facts.chunked(2).forEach { row ->
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    row.forEach { fact ->
                        BrandCard(Modifier.weight(1f)) {
                            Text(
                                fact.label.uppercase(Locale.US),
                                color = Brand.navy,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold,
                                letterSpacing = 0.6.sp
                            )
                            Spacer(Modifier.height(6.dp))
                            Text(fact.value, color = Brand.ink, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                        }
                    }
                }
            }
        }
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Eyebrow("Corporate Values")
            SectionTitle("Integrity, Quality, and Value")
            BodyText(Company.valuesIntro)
            Company.values.forEach { value ->
                BrandCard {
                    Text(value.name, color = Brand.navy, fontSize = 17.sp, fontWeight = FontWeight.SemiBold)
                    Spacer(Modifier.height(6.dp))
                    BodyText(value.detail)
                }
            }
        }
        Text(
            "© 2026 ${Company.name}. All rights reserved.\nSmall Business · Founded 2004",
            color = Brand.muted,
            fontSize = 13.sp,
            lineHeight = 18.sp
        )
    }
}

@Composable
fun CapabilitiesScreen(onOpen: (Int) -> Unit) {
    AppScreen("Capabilities") {
        Eyebrow("Capabilities")
        SectionTitle("Specialized Expertise for Complex Missions")
        BodyText(Company.capabilitiesIntro)
        Company.capabilities.forEachIndexed { index, capability ->
            BrandCard(onClick = { onOpen(index) }) {
                Row(horizontalArrangement = Arrangement.spacedBy(14.dp)) {
                    MarkIcon(capability.icon)
                    Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(capability.name, color = Brand.ink, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                        Text(capability.summary, color = Brand.muted, fontSize = 14.sp, lineHeight = 20.sp)
                    }
                    Icon(
                        Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = null,
                        tint = Brand.muted,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun CapabilityDetailScreen(capability: Capability, onBack: () -> Unit) {
    val context = LocalContext.current
    AppScreen(capability.name, largeTitle = false, spacing = 18.dp, onBack = onBack) {
        MarkIcon(capability.icon, size = 52.dp)
        Text(capability.name, color = Brand.ink, fontSize = 22.sp, fontWeight = FontWeight.Bold, lineHeight = 28.sp)
        BodyText(capability.summary)
        BodyText(Company.capabilitiesIntro, color = Brand.ink)
        Spacer(Modifier.height(8.dp))
        FilledAction("Discuss on LinkedIn") { context.openUrl(Company.linkedIn) }
        Text(Company.linkedInNote, color = Brand.muted, fontSize = 13.sp, lineHeight = 18.sp)
    }
}

@Composable
fun ExperienceScreen() {
    AppScreen("Experience") {
        Eyebrow("Experience & Trust")
        SectionTitle(Company.experienceTitle)
        Company.experience.forEach { BodyText(it) }
        Company.partnerships.forEach { item ->
            BrandCard {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    MarkIcon(item.icon)
                    Text(
                        item.name,
                        color = Brand.ink,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
fun CareersScreen() {
    val context = LocalContext.current
    AppScreen("Careers", spacing = 18.dp) {
        Eyebrow("Careers")
        SectionTitle("Build Your Career With Modus21")
        Text(Company.cultureTitle, color = Brand.navy, fontWeight = FontWeight.SemiBold, fontSize = 17.sp)
        BodyText(Company.culture)
        Text("Benefits", color = Brand.navy, fontWeight = FontWeight.SemiBold, fontSize = 17.sp)
        Company.benefits.forEach { benefit ->
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Box(
                    Modifier
                        .size(22.dp)
                        .background(Brand.navy.copy(alpha = 0.08f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Filled.Check, contentDescription = null, tint = Brand.navy, modifier = Modifier.size(14.dp))
                }
                Text(benefit, color = Brand.ink, fontSize = 16.sp, lineHeight = 22.sp, modifier = Modifier.weight(1f))
            }
        }
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            FilledAction("Open Positions") { context.openUrl(Company.jobs) }
            OutlineAction(Company.careersEmail) { context.openMail() }
        }
        Text(Company.careersPrompt, color = Brand.muted, fontSize = 13.sp, lineHeight = 18.sp)
        Text(Company.equalOpportunity, color = Brand.muted, fontSize = 13.sp, lineHeight = 18.sp)
    }
}

@Composable
fun ContactScreen(onPrivacy: () -> Unit, onAccessibility: () -> Unit) {
    val context = LocalContext.current
    AppScreen("Contact") {
        Eyebrow("Contact Us")
        SectionTitle("Let's Discuss Your Mission")
        BodyText(Company.contactPrompt)
        AndroidView(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(16.dp))
                .semantics {
                    contentDescription = "Map showing the Modus21 office in North Charleston, South Carolina"
                },
            factory = { ctx ->
                WebView(ctx).apply {
                    webViewClient = WebViewClient()
                    setBackgroundColor(android.graphics.Color.parseColor("#F4F6F8"))
                    isVerticalScrollBarEnabled = false
                    isHorizontalScrollBarEnabled = false
                    loadUrl(Company.mapEmbed)
                }
            }
        )
        BrandCard {
            Text(
                "LOCATION",
                color = Brand.navy,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 0.6.sp
            )
            Spacer(Modifier.height(4.dp))
            Text(Company.name, color = Brand.ink, fontWeight = FontWeight.SemiBold, fontSize = 17.sp)
            Text(Company.street, color = Brand.ink, fontSize = 16.sp)
            Text(Company.suite, color = Brand.ink, fontSize = 16.sp)
            Text(Company.cityLine, color = Brand.ink, fontSize = 16.sp)
        }
        ActionRow("LinkedIn", Company.linkedInNote, Icons.Filled.Link) { context.openUrl(Company.linkedIn) }
        ActionRow("Call", Company.phoneDisplay, Icons.Filled.Phone) { context.openDial() }
        ActionRow("Email", Company.careersEmail, Icons.Filled.Email) { context.openMail() }
        ActionRow("Directions", "Open the North Charleston office in Maps", Icons.Filled.Map) { context.openMaps() }
        ActionRow("Website", "modus21.com", Icons.Filled.Language) { context.openUrl(Company.website) }
        Column(
            Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
                .border(1.dp, Brand.line, RoundedCornerShape(16.dp))
        ) {
            LegalRow("Privacy Notice", onPrivacy)
            HorizontalDivider(color = Brand.line)
            LegalRow("Accessibility Statement", onAccessibility)
        }
        Text(Company.footer, color = Brand.muted, fontSize = 13.sp, lineHeight = 18.sp)
    }
}

@Composable
private fun ActionRow(title: String, subtitle: String, icon: ImageVector, onClick: () -> Unit) {
    BrandCard(onClick = onClick) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(14.dp)) {
            MarkIcon(icon)
            Column(Modifier.weight(1f)) {
                Text(title, color = Brand.ink, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                Text(subtitle, color = Brand.muted, fontSize = 14.sp, lineHeight = 18.sp)
            }
            Icon(Icons.Filled.NorthEast, contentDescription = null, tint = Brand.muted, modifier = Modifier.size(16.dp))
        }
    }
}

@Composable
private fun LegalRow(title: String, onClick: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 18.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(title, color = Brand.ink, fontWeight = FontWeight.SemiBold, fontSize = 16.sp, modifier = Modifier.weight(1f))
        Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null, tint = Brand.muted)
    }
}

@Composable
fun PrivacyScreen(onBack: () -> Unit) {
    val context = LocalContext.current
    AppScreen("Privacy Notice", largeTitle = false, onBack = onBack) {
        Text("Effective Date: 4 August 2026", color = Brand.navy, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
        BodyText("This notice describes the privacy practices Modus21, LLC publishes for www.modus21.com and for personal information collected in the course of its business.")
        LegalBlock(
            "What may be collected",
            "Personal information can include a name, physical address, telephone number, email address, emergency contact details, company affiliation, and associated interests. Other information can include browser and device details, usage data, demographic or location information, and statistical or aggregated data. When other information is combined with personal information, Modus21 treats the combination as personal information."
        )
        LegalBlock(
            "How it is used",
            "Published uses include responding to requests, employment consideration and human resources, submitting bids and proposals, security and fraud prevention, legal compliance, and testing, research, and improvement of the site and services."
        )
        LegalBlock(
            "Cookies and analytics",
            "The site may use cookies, web server logs, and third-party analytics to understand traffic and to prefill forms. Browser settings can refuse cookies. Server logs may include device, browser, language, time zone, referring page, and IP address."
        )
        LegalBlock(
            "Sharing",
            "Modus21 states that it does not share gathered or aggregated demographic information except when required by law or legal process, when formally requested by law enforcement or government entities, when disclosure is necessary to prevent harm or financial loss, in connection with investigations of security events or illegal activity, or for any other legal purpose."
        )
        LegalBlock(
            "Automated access",
            "Site content is provided for human visitors and authorized business use. Bots, scrapers, and similar automated access are prohibited without prior written permission, including use of site content to train or improve AI or machine learning models. Recognized search engines may index public pages. Questions can be sent to careers@modus21.com or 843-958-8900."
        )
        LegalBlock(
            "Security and changes",
            "Modus21 maintains safeguards and states that no internet system can be fully secure. The notice can change by posting an update on the site. The effective date at the top of the notice shows the latest revision."
        )
        FilledAction("Read the Full Notice") { context.openUrl(Company.privacyUrl) }
    }
}

@Composable
fun AccessibilityScreen(onBack: () -> Unit) {
    val context = LocalContext.current
    AppScreen("Accessibility", largeTitle = false, onBack = onBack) {
        Text("Effective Date: 4 August 2026", color = Brand.navy, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
        BodyText("Modus21, LLC is committed to making www.modus21.com accessible to the widest possible audience, including people with disabilities. The public site aims to conform to Section 508 and WCAG 2.0 Level AA.")
        LegalBlock(
            "Published practices",
            "Semantic headings and landmarks, keyboard access, visible focus, text alternatives for meaningful images, a skip link, support for reduced motion where animations are used, and a clear indication when a link opens in a new tab."
        )
        LegalBlock(
            "Known limitations",
            "Modus21 notes that some secondary text contrast, reduced-motion behavior, and third-party content may not yet meet every standard. Third-party sites such as LinkedIn and external job systems follow those providers' practices."
        )
        LegalBlock(
            "Feedback",
            "If you have trouble with the website or need an accommodation, call 843-958-8900 or email careers@modus21.com. Describe the page, the barrier, and any assistive technology you use."
        )
        FilledAction("Read the Full Statement") { context.openUrl(Company.accessibilityUrl) }
    }
}

@Composable
private fun LegalBlock(title: String, body: String) {
    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
        Text(title, color = Brand.ink, fontWeight = FontWeight.SemiBold, fontSize = 17.sp)
        BodyText(body)
    }
}

private fun Context.tryStart(intent: Intent) {
    try {
        startActivity(intent)
    } catch (_: ActivityNotFoundException) {
        Toast.makeText(this, "No app available to open this link.", Toast.LENGTH_SHORT).show()
    }
}

private fun Context.openUrl(url: String) {
    tryStart(Intent(Intent.ACTION_VIEW, url.toUri()))
}

private fun Context.openDial() {
    tryStart(Intent(Intent.ACTION_DIAL, Company.phoneUri.toUri()))
}

private fun Context.openMail() {
    tryStart(Intent(Intent.ACTION_SENDTO, Company.careersMail.toUri()))
}

private fun Context.openMaps() {
    val geo = Intent(
        Intent.ACTION_VIEW,
        "geo:${Company.latitude},${Company.longitude}?q=${Company.latitude},${Company.longitude}(Modus21)".toUri()
    )
    try {
        startActivity(geo)
    } catch (_: ActivityNotFoundException) {
        openUrl("https://maps.google.com/?q=${Company.latitude},${Company.longitude}")
    }
}
